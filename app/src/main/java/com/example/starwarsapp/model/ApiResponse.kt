package com.example.starwarsapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiResponse(
    @SerializedName("results")
    val results: List<FilmResponse>
    ): Serializable
