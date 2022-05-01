package com.example.starwarsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FilmEntity::class], version = 1)
abstract class FilmsDatabase:RoomDatabase() {

    abstract fun filmsDao(): FilmsDAO

    companion object {
        @Volatile
        private var INSTANCE: FilmsDatabase? = null

        fun getInstance(context: Context): FilmsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FilmsDatabase::class.java,
                    "FilmsDB"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                instance
            }
        }

    }
}

