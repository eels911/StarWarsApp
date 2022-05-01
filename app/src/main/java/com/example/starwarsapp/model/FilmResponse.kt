package com.example.starwarsapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class FilmResponse(
  @SerializedName("title")
  val title: String,
  @SerializedName("director")
  val director: String,
  @SerializedName("producer")
  val producer: String,
  @SerializedName("release_date")
  val releaseDate:String,
  @SerializedName("episode_id")
  val episodeId:Int
): Serializable