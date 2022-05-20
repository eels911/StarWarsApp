package com.example.core.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    /**
     * Create a provider method binding for [Application].
     *
     * @return Instance of application.
     * @see Provides
     */
    @Singleton
    @Provides
    internal fun provideApplication(): Application = application
}