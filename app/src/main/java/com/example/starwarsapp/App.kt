package com.example.starwarsapp

import android.app.Application

class App:Application() {
    override fun onCreate() {
        super.onCreate()
//        FilmRepositoryImpl.createDatabase(this)
    }

}