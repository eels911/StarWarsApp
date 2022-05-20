package com.example.feature.viewmodel

import com.example.core.base.BaseViewModel
import com.example.core.domain.GetCharacterUseCase
import com.example.core.response.Character
import com.example.core.util.schedulers.BaseSchedulerProvider
import com.example.feature.model.CharacterWrapper
import com.example.feature.model.CharactersWrapper
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    schedulerProvider: BaseSchedulerProvider,
    character: Character,
    getCharacterUseCase: GetCharacterUseCase
):BaseViewModel<CharactersWrapper>(schedulerProvider,
Single.zip(
    Flowable.fromIterable(character.characterUrls)
        .flatMapSingle{characterUrl -> getCharacterUseCase(characterUrl)}
        .toList(), { characters -> CharactersWrapper(characters)
        }))