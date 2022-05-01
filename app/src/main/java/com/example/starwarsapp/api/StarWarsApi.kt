package com.example.starwarsapp.api

import com.example.starwarsapp.model.ApiResponse
import io.reactivex.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.Result

interface StarWarsApi {
//    @GET("films/")
//    suspend fun getFilmsFromResults(): ApiResponse
    @GET("films/")
    fun getFilmsFromResults(): Single<ApiResponse>

    @GET("films/")
    fun searchFilm(@Query("search") search: String? = null): Observable<ApiResponse>

}