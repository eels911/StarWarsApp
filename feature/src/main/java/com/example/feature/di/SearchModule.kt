package com.example.feature.di

import android.app.Application
import com.example.core.domain.SearchFilmUseCase
import com.example.core.extension.viewModel
import com.example.core.util.schedulers.BaseSchedulerProvider
import com.example.feature.ui.search.SearchFragment
import com.example.feature.viewmodel.SearchViewModel
import dagger.Module
import dagger.Provides

/**
 * Class that contributes to the object graph [SearchComponent].
 *
 * @see Module
 */
@Module
class SearchModule(private val fragment: SearchFragment) {

    /**
     * Create a provider method binding for [SearchViewModel].
     *
     * @return Instance of view model.
     * @see Provides
     */
    @Provides
    fun providesSearchViewModel(
        useCase: SearchFilmUseCase,
        schedulerProvider: BaseSchedulerProvider,
        application: Application,
    ) = fragment.viewModel {
        SearchViewModel(useCase, schedulerProvider, application)
    }
}