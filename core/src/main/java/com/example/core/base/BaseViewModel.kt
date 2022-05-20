package com.example.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.util.*
import com.example.core.util.Resource
import com.example.core.util.schedulers.BaseSchedulerProvider
import io.reactivex.rxjava3.core.Single


open class BaseViewModel<T>(
    private val schedulerProvider: BaseSchedulerProvider,
    private val singleRequest: Single<T>,
) : ViewModel() {

    private val _liveData = MutableLiveData<Resource<T>>()
    val liveData: LiveData<Resource<T>>
        get() = _liveData

    init {
        sendRequest()
    }

    fun sendRequest() {
        _liveData.value = Resource.Loading
        singleRequest.subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                _liveData.postValue(Resource.Success(it))
            }) {
                _liveData.postValue(Resource.Error(it.localizedMessage))
            //    Timber.e(it)
            }.also { DisposableManager.add(it) }
    }

    /**
     * Called when the ViewModel is dismantled.
     * At this point, we want to cancel all disposables;
     * otherwise we end up with processes that have nowhere to return to
     * using memory and resources.
     */
    override fun onCleared() {
        super.onCleared()
        DisposableManager.clear()
    }
}