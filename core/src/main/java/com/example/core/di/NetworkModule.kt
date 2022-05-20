package com.example.core.di

import com.example.core.BuildConfig
import com.example.core.network.StarWarsService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

@Singleton
@Provides
fun provideRetrofit( gson: Gson,okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Singleton
    @Provides
    fun provideStarWarsService(retrofit: Retrofit): StarWarsService =
        retrofit.create(StarWarsService::class.java)

}