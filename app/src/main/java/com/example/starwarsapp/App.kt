package com.example.starwarsapp

import android.app.Application
import android.content.Context
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent
import com.example.starwarsapp.di.DaggerAppComponent

class App:Application() {

    lateinit var coreComponent: CoreComponent
    companion object {

        /**
         * Obtain core dagger component.
         *
         * @param context The application context
         */
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as App).coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
        initAppDependencyInjection()
//        FilmRepositoryImpl.createDatabase(this)

    }
    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }
    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .applicationModule(com.example.core.di.ApplicationModule(this))
            .build()
    }
}