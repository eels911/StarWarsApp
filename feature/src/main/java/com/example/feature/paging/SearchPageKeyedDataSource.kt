package com.example.feature.paging

import android.content.Context
import com.example.core.base.BasePageKeyedDataSource
import com.example.core.domain.SearchFilmUseCase
import com.example.core.paging.NetworkState
import com.example.core.response.Film
import com.example.core.response.FilmWrapper
import com.example.core.util.schedulers.BaseSchedulerProvider
import com.example.core.util.DisposableManager
import io.reactivex.rxjava3.core.Observable


class SearchPageKeyedDataSource(
    private val searchFilmUseCase: SearchFilmUseCase,
    private val query: String,
    schedulerProvider: BaseSchedulerProvider,
    context: Context,
) : BasePageKeyedDataSource<Film, FilmWrapper>(
    schedulerProvider, context) {

    private var isNext = true

    override fun fetchObservableItem(page: Int): Observable<FilmWrapper> =
        searchFilmUseCase(query, page)

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Film>) {
        if (isNext) {
            mutableNetworkState.postValue(NetworkState.LOADING)
            fetchItems(params.key).subscribe({
                mutableNetworkState.postValue(NetworkState.LOADED)
                //clear retry since last request succeeded
                retry = null
                if (it.next == null) {
                    isNext = false
                }
                callback.onResult(it.wrapper, params.key + 1)
            }) {
                retry = {
                    loadAfter(params, callback)
                }
                setErrorMsg(it)
            }.also { DisposableManager.add(it) }
        }
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Film>,
    ) {
        mutableNetworkState.postValue(NetworkState.LOADING)
        fetchItems(1).subscribe({
            mutableNetworkState.postValue(NetworkState.LOADED)
            if (it.next == null) {
                isNext = false
            }
            callback.onResult(it.wrapper, null, 2)
        }) {
            retry = {
                loadInitial(params, callback)
            }
            setErrorMsg(it)
        }.also { DisposableManager.add(it) }
    }


}