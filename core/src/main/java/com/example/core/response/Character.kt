package com.example.core.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character(
    @SerializedName("name")
    val name: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("characters")
    val characterUrls: List<String>
): Serializable