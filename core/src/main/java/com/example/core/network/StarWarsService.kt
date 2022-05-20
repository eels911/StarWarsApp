package com.example.core.network

import com.example.core.response.Character
import com.example.core.response.FilmWrapper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface StarWarsService {
    @GET("film/")
    fun searchFilm(
        @Query("search") query: String,
        @Query("page") page: Int,
    ): Observable<FilmWrapper>

    @GET
    fun getCharacter(@Url url:String): Single<Character>
}