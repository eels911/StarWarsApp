package com.example.starwarsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FilmsDAO {
    @Insert(entity = FilmEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertFilms(films: List<FilmEntity>)

    @Query("SELECT * FROM films_table")
    fun getAllfilms():LiveData<List<FilmEntity>>
}
