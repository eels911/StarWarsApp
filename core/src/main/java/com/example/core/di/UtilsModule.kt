package com.example.core.di

import com.example.core.util.schedulers.BaseSchedulerProvider
import com.example.core.util.schedulers.SchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Class that contributes to the object graph [CoreComponent].
 *
 * @see Module
 */
@Module
abstract class UtilsModule {

    /**
     * Create a provider method binding for [SchedulerProvider].
     *
     * @return Instance of SchedulerProvider.
     * @see Binds
     */
    @Singleton
    @Binds
    internal abstract fun bindSchedulerProvider(schedulerProvider: SchedulerProvider): BaseSchedulerProvider
}