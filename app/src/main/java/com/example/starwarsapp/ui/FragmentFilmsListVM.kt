package com.example.starwarsapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.starwarsapp.NetworkService
import com.example.starwarsapp.api.Failure
import com.example.starwarsapp.api.Result
import com.example.starwarsapp.api.Success
import com.example.starwarsapp.di.DaggerApiComponent
import com.example.starwarsapp.model.FilmModel
import com.example.starwarsapp.model.FilmResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import javax.inject.Inject

class FragmentFilmsListVM: ViewModel() {
//    val searchMoviesLiveData = MutableLiveData<List<FilmModel>>()
//    val movieLoadingStateLiveData = MutableLiveData<MovieLoadingState>()
//    var filmsListLiveData: MutableLiveData<List<FilmModel>> = MutableLiveData()
    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    private val filmsList by lazy { MutableLiveData<List<FilmResponse>>() }
    val filmsListLD: LiveData<List<FilmResponse>>
        get() = filmsList
    private val inProgress by lazy { MutableLiveData<Boolean>() }
    val inProgressLD: LiveData<Boolean>
        get() = inProgress
    private val isError by lazy { MutableLiveData<Boolean>() }
    val isErrorLD: LiveData<Boolean>
        get() = isError

    init {
        DaggerApiComponent.create().inject(this)
        fetchFilms()
    }
//    init {
//        loadFilms()
//    }

//    fun saveDataIntoDb(data: FilmEntity){
//        dataBaseInstance?.filmsDao()?.insertFilms(data)
//            ?.subscribeOn(Schedulers.io())
//            ?.observeOn(AndroidS)
//    }

//    private fun loadFilms(){
//        viewModelScope.launch {
//            val films = FilmRepositoryImpl.loadMovies()
//
//            handleResult(films)
//        }
//    }
//    private fun handleResult(result: Result<List<FilmModel>>) {
//        when (result) {
//            is Success -> filmsListLiveData.postValue(result.data)
//            is Failure -> filmsListLiveData.postValue(emptyList())
//        }
//    }
fun refresh(){
    fetchFilms()
}

    private fun fetchFilms() {
        compositeDisposable.add( // API call get stored in compositeDisposable
            networkService.fetchVehicle() // Makes the call to the endpoint
                .subscribeOn(Schedulers.io()) // Subscribes on a background thread, which is Schedulers.io()
                .observeOn(AndroidSchedulers.mainThread()) // Displays the result on the main thread (UI thread)
                .map { it.results } // Takes the list of vehicles in VehiclesResult pass it on to the next operator
                .subscribeWith(createFilmObserver()) // The glue that connects networkService.fetchVehicle() with createVehicleObserver()
        )
    }

    private fun createFilmObserver(): DisposableSingleObserver<List<FilmResponse>> {
        return object : DisposableSingleObserver<List<FilmResponse>>() {
            override fun onSuccess(films: List<FilmResponse>) {
                inProgress.value = true
                isError.value = false
                filmsList.value = films
                inProgress.value = false
            }

            override fun onError(e: Throwable) {
                inProgress.value = true
                isError.value = true
                Log.e("onError()", "Error: ${e.message}")
                inProgress.value = false
            }
        }
    }



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


}
