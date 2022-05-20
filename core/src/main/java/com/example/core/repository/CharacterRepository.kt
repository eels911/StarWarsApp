package com.example.core.repository

import com.example.core.response.Character
import io.reactivex.rxjava3.core.Single

interface CharacterRepository {
    fun getCharacter(url: String): Single<Character>
}