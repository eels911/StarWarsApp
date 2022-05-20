package com.example.feature.model

import android.content.Context
import com.example.core.response.Film
import com.example.feature.R

class CharactersWrapper(
    val characters: List<CharacterWrapper>,
//    val films: List<Film>,
)

class CharacterWrapper(
    val name: String,
    val birthYear: String,
    val gender: String,
) {
    companion object {
        fun getUnAvailableCharacter(context: Context): CharacterWrapper {
            val notAvailableLabel = context.getString(R.string.label_not_available)
            return CharacterWrapper(notAvailableLabel, notAvailableLabel, notAvailableLabel)
        }
    }
}