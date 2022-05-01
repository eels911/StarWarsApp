package com.example.starwarsapp.di

import com.example.starwarsapp.NetworkService
import com.example.starwarsapp.api.StarWarsApi
import com.example.starwarsapp.model.FilmResponse
import com.example.starwarsapp.ui.FilmAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    @Provides
    fun provideStarWarsApi(): StarWarsApi {
        return Retrofit.Builder()
            .baseUrl(NetworkService.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWarsApi::class.java)
    }
    @Provides
    fun provideNetworkService(): NetworkService {
        return NetworkService()
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
    @Provides
    fun provideFilmList(): ArrayList<FilmResponse> {
        return ArrayList()
    }

    @Provides
    fun provideFilmAdapter(films: ArrayList<FilmResponse>): FilmAdapter {
        return FilmAdapter(films)
    }
}