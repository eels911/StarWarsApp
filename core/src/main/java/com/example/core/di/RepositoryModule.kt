package com.example.core.di

import com.example.core.repository.SearchRepository
import com.example.core.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Singleton
    @Binds
    internal abstract fun bindSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository

}