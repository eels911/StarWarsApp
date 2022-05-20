package com.example.core.repository

import com.example.core.response.FilmWrapper
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {
    fun searchFilm(query: String, page: Int): Observable<FilmWrapper>
}