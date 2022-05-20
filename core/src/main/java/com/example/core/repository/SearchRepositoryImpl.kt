package com.example.core.repository

import com.example.core.network.StarWarsService
import com.example.core.response.FilmWrapper
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val service: StarWarsService
):SearchRepository {
    override fun searchFilm(query: String, page: Int): Observable<FilmWrapper> =
        service.searchFilm(query, page)
}