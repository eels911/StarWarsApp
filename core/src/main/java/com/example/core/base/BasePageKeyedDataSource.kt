package com.example.core.base

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.core.R
import com.example.core.extension.isNetworkAvailable
import com.example.core.paging.NetworkState
import com.example.core.util.schedulers.BaseSchedulerProvider
import com.example.core.util.NetworkException
import io.reactivex.rxjava3.core.Observable

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

abstract class BasePageKeyedDataSource<T : Any, K>(
    private val schedulerProvider: BaseSchedulerProvider,
    private val context: Context,
) : PageKeyedDataSource<Int, T>() {

    // thread pool used for network requests
    private val networkIO: ExecutorService = Executors.newFixedThreadPool(5)

    // keep a function reference for the retry event
    protected var retry: (() -> Any)? = null
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        // ignored, since we only ever append to our initial load
    }
    /**
     * There is no sync on the state because paging will always call loadInitial first then wait
     * for it to return some success value before calling loadAfter.
     */
    protected val mutableNetworkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = mutableNetworkState

    fun retryAllFailed() {
        val prevRetry = retry
        retry = null
        prevRetry?.let {
            networkIO.execute {
                it.invoke()
            }
        }
    }


    protected abstract fun fetchObservableItem(page: Int): Observable<K>

    protected fun fetchItems(page: Int): Observable<K> =
        Observable.fromCallable { context.isNetworkAvailable() }.flatMap {
            return@flatMap if (it) fetchObservableItem(page)
            else Observable.error(NetworkException())
        }

    protected fun setErrorMsg(throwable: Throwable) {
        mutableNetworkState.postValue(
            NetworkState.error(
                context.getString(
                    if (throwable is NetworkException) R.string.failed_network_msg
                    else R.string.failed_loading_msg
                )
            )
        )
    }
}
