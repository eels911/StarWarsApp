package com.example.feature.di

import com.example.core.domain.SearchFilmUseCase
import com.example.core.response.Film
import com.example.core.util.schedulers.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

///**
// * Class that contributes to the object graph [DetailComponent].
// *
// * @see Module
// */
//@Module
//class DetailModule(private val fragment: DetailFragment) {
//
//    /**
//     * Create a provider method binding for [DetailViewModel].
//     *
//     * @return Instance of view model.
//     * @see Provides
//     */
//    @Provides
//    fun providesDetailViewModel(
//        schedulerProvider: BaseSchedulerProvider,
////        getSpecieUseCase: GetSpecieUseCase,
////        getPlanetUseCase: GetPlanetUseCase,
//        searchFilmUseCase: SearchFilmUseCase,
//        film: Film,
//    ) = fragment.viewModel {
//        DetailViewModel(schedulerProvider, character, getSpecieUseCase,
//            getPlanetUseCase, getFilmUseCase)
//    }
//
//    @Provides
//    internal fun provideCharacter(): Character {
//        val args: DetailFragmentArgs by fragment.navArgs()
//        return args.character
//    }
//}