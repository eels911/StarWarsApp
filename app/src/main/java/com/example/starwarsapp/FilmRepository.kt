package com.example.starwarsapp

import android.content.Context
import android.util.Log
import com.example.starwarsapp.api.Result
import com.example.starwarsapp.api.RetrofitInstance.api
import com.example.starwarsapp.api.StarWarsApi
import com.example.starwarsapp.api.Success
import com.example.starwarsapp.api.runCatchingResult
import com.example.starwarsapp.db.FilmsDatabase
import com.example.starwarsapp.model.ApiResponse
import com.example.starwarsapp.model.FilmModel
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//interface FilmRepository {
//    suspend fun loadMovies(): Result<List<FilmModel>>
////    suspend fun loadMoviesToDb()
//}
//
//object FilmRepositoryImpl: FilmRepository{
//    private lateinit var db: FilmsDatabase
////   suspend fun fetchFilms() {
////        api.getFilms()
////    }
////suspend fun parseJson() {
////
////        CoroutineScope(Dispatchers.IO).launch{
////            val response = api.getFilms()
////            withContext(Dispatchers.Main) {
////                if (response.isSuccessful) {
////                    val items = response.body()?.results
////                    if (items != null){
////                        for (i in 0 until items.count()){
////                            val id = items[i].episodeId ?: "N/A"
////                            Log.d("ID: ",id.toString())
////                        }
////                    }
////                }
////            }
////        }
////    }
//    fun createDatabase(context:Context){
//        db = FilmsDatabase.getInstance(context)
//    }
//
//    fun fetchFilm(): Single<ApiResponse> {
//        return api.getFilmsFromResults()
//    }
//
////    override suspend fun loadMoviesToDb() {
////        val result = runCatchingResult { getFilms() }
////        if (result is Success) {
////
////            val films = result.data
//////
//////                db.filmsDao().insertFilms(films.map { it.toFilmsEntity() })
//////                val data = db.filmsDao().getAllfilms()
////
////        }
////    }
//            override suspend fun loadMovies(): Result<List<FilmModel>> {
//        return runCatchingResult { getFilms() }
//    }
//
//    private suspend fun getFilms(): List<FilmModel>{
//        return api.getFilmsFromResults().results.map {film ->
//            FilmModel(
//                title =  film.title,
//                director = film.director,
//                producer = film.producer,
//                releaseDate = film.releaseDate,
//                episodeId = film.episodeId
//            )
//        }
////            .sortedBy { it.episodeId }
//    }
//
//    }
