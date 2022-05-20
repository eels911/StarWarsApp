package com.example.feature.paging

import android.content.Context
import com.example.core.base.BaseDataSourceFactory
import com.example.core.base.BasePageKeyedDataSource
import com.example.core.domain.SearchFilmUseCase
import com.example.core.response.Film
import com.example.core.response.FilmWrapper
import com.example.core.util.schedulers.BaseSchedulerProvider

class SearchDataSourceFactory(
    searchFilmUseCase: SearchFilmUseCase,
    query: String,
    schedulerProvider: BaseSchedulerProvider,
    context: Context,
) : BaseDataSourceFactory<Film, FilmWrapper>() {

    override val dataSource: BasePageKeyedDataSource<Film, FilmWrapper> =
        SearchPageKeyedDataSource(
            searchFilmUseCase = searchFilmUseCase,
            query = query,
            schedulerProvider = schedulerProvider,
            context = context
        )
}
