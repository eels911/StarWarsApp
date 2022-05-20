package com.example.core.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmWrapper(
    @SerializedName("results")
    val wrapper: List<Film>,
    val next: String?
):Serializable
