package com.example.feature.paging

import android.content.Context
import com.example.core.base.BaseDataSourceFactory
import com.example.core.base.BasePageKeyRepository
import com.example.core.domain.SearchFilmUseCase
import com.example.core.response.Film
import com.example.core.response.FilmWrapper
import com.example.core.util.schedulers.BaseSchedulerProvider

class SearchPageKeyRepository(
    searchFilmUseCase: SearchFilmUseCase,
    query: String,
    schedulerProvider: BaseSchedulerProvider,
    context: Context,
) : BasePageKeyRepository<Film, FilmWrapper>(schedulerProvider) {

    override val sourceFactory: BaseDataSourceFactory<Film, FilmWrapper> =
        SearchDataSourceFactory(
            searchFilmUseCase = searchFilmUseCase,
            query = query,
            schedulerProvider = schedulerProvider,
            context = context
        )
}