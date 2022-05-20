package com.example.core.repository

import com.example.core.network.StarWarsService
import com.example.core.response.Character
import com.example.core.response.FilmWrapper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val service: StarWarsService
):CharacterRepository{
    override fun getCharacter(url:String): Single<Character> = service.getCharacter(url)

}