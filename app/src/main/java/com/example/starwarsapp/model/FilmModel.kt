package com.example.starwarsapp.model

import androidx.room.PrimaryKey
import com.example.starwarsapp.db.FilmEntity
import java.io.Serializable

data class FilmModel(
    val title: String,
    val director: String,
    val producer: String,
    val releaseDate:String,
    val episodeId:Int
): Serializable{
    fun toFilmsEntity() = FilmEntity(

                title = title
    )
}
