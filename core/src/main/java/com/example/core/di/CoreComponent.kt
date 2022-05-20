package com.example.core.di

import android.app.Application
import com.example.core.network.StarWarsService
import com.example.core.repository.SearchRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,
    NetworkModule::class,
    RepositoryModule::class]
)
interface CoreComponent {
    /**
     * Provide dependency graph Application
     *
     * @return Application
     */
    fun application(): Application

    /**
     * Provide dependency graph StarWarsService
     *
     * @return StarWarsService
     */
    fun starWarsService(): StarWarsService
    /**
     * Provide dependency graph SearchRepositoryImpl
     *
     * @return SearchRepository
     */
    fun searchRepository(): SearchRepository

}