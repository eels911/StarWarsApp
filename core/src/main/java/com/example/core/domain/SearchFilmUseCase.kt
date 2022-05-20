package com.example.core.domain

import com.example.core.repository.SearchRepository
import com.example.core.response.FilmWrapper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchFilmUseCase @Inject constructor(
    private val searchFilmRepository: SearchRepository
) {
    operator fun invoke(query:String, page: Int): Observable<FilmWrapper> =
        searchFilmRepository.searchFilm(query,page)
}