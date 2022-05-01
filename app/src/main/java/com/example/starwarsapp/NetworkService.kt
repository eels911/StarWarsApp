package com.example.starwarsapp

import com.example.starwarsapp.api.StarWarsApi
import com.example.starwarsapp.di.DaggerApiComponent
import com.example.starwarsapp.model.ApiResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NetworkService {
    @Inject
    lateinit var starWarsApi: StarWarsApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun fetchVehicle(): Single<ApiResponse> {
        return starWarsApi.getFilmsFromResults()
    }

    companion object {
        val BASE_URL = "https://swapi.dev/api/"
    }
}