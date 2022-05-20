package com.example.core.domain

import com.example.core.repository.CharacterRepository
import com.example.core.repository.SearchRepository
import com.example.core.response.Character
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(url: String): Single<Character> = characterRepository.getCharacter(url)
}