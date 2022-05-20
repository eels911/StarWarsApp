package com.example.feature.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.core.base.BasePagingViewModel
import com.example.core.domain.GetFilmsPagesUseCase
import com.example.core.domain.SearchFilmUseCase
import com.example.core.paging.Listing
import com.example.core.response.Film
import com.example.core.util.schedulers.BaseSchedulerProvider
import com.example.feature.paging.SearchPageKeyRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchFilmUseCase: SearchFilmUseCase,
    //private val getFilmsPagesUseCase: GetFilmsPagesUseCase
    private val schedulerProvider: BaseSchedulerProvider,
    private val app: Application
) : BasePagingViewModel<Film>(app) {
    private val query = MutableLiveData<String>()

    override val repoResult: LiveData<Listing<Film>> = Transformations.map(query) {
        SearchPageKeyRepository(searchFilmUseCase, it, schedulerProvider, app.applicationContext
        ).getItems()
    }

    fun showQuery(query: String): Boolean {
        if (this.query.value == query) {
            return false
        }
        this.query.value = query
        return true
    }
}