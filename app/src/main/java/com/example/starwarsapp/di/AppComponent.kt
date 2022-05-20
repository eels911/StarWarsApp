package com.example.starwarsapp.di

import com.example.core.di.AppScope
import com.example.core.di.CoreComponent
import com.example.starwarsapp.App

import dagger.Component
@AppScope
@Component(
    dependencies = [CoreComponent::class]
)
interface AppComponent {
    fun inject(application: App)
}