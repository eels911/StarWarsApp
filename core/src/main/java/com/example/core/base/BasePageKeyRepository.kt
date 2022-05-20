package com.example.core.base

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import androidx.paging.rxjava3.RxPagedListBuilder
import com.example.core.paging.Listing
import com.example.core.paging.PageKeyRepository
import com.example.core.util.schedulers.BaseSchedulerProvider
import com.example.core.util.DisposableManager

abstract class BasePageKeyRepository<T : Any, R>(
    private val scheduler: BaseSchedulerProvider,
) : PageKeyRepository<T> {

    protected abstract val sourceFactory: BaseDataSourceFactory<T, R>

    @MainThread
    override fun getItems(): Listing<T> {

        val rxPagedList = RxPagedListBuilder(sourceFactory, PAGE_SIZE)
            .setFetchScheduler(scheduler.io()).buildObservable()

        val networkState = Transformations.switchMap(sourceFactory.sourceLiveData) {
            it.networkState
        }

        val pagedList = MutableLiveData<PagedList<T>>()

        rxPagedList.subscribeOn(scheduler.io()).subscribe {
            pagedList.postValue(it)
        }.also { DisposableManager.add(it) }

        return Listing(
            pagedList = pagedList,
            networkState = networkState,
            retry = {
                sourceFactory.sourceLiveData.value?.retryAllFailed()
            }
        )
    }

    companion object {
        private const val PAGE_SIZE = 10
    }
}