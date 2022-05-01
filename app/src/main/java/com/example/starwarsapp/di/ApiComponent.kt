package com.example.starwarsapp.di

import com.example.starwarsapp.NetworkService
import com.example.starwarsapp.ui.FragmentFilmsListVM
import com.example.starwarsapp.ui.MainActivity
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(networkService: NetworkService)
    fun inject(filmViewModel: FragmentFilmsListVM)
    fun inject(mainActivity: MainActivity)
}