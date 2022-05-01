package com.example.starwarsapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "films_table")
data class FilmEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 9,
    val title: String,
//    val episodeId:Int
): Serializable{

}
