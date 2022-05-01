package com.example.starwarsapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.R
import com.example.starwarsapp.model.ApiResponse
import com.example.starwarsapp.model.FilmModel
import com.example.starwarsapp.model.FilmResponse

class FilmAdapter(
    private val context: ArrayList<FilmResponse>,
):RecyclerView.Adapter<FilmAdapter.ViewHolderFilms>() {
    var filmsList: List<FilmResponse> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.ViewHolderFilms {
        return ViewHolderFilms(LayoutInflater.from(parent.context).inflate(R.layout.item_film,parent,false))
    }

    override fun onBindViewHolder(holder: FilmAdapter.ViewHolderFilms, position: Int) {
        holder.bind(getItem(position))
    }
    private fun getItem(position:Int): FilmResponse = filmsList[position]

    override fun getItemCount(): Int = filmsList.size
    fun refresh(films: List<FilmResponse>) {
        filmsList = films
        notifyDataSetChanged()
    }
        inner class ViewHolderFilms(v: View) : RecyclerView.ViewHolder(v){
        private val filmName: TextView = itemView.findViewById(R.id.film_name)
        private val director: TextView = itemView.findViewById(R.id.director)
        private val producer: TextView = itemView.findViewById(R.id.producer)
        private val releaseDate: TextView = itemView.findViewById(R.id.releaseDate)

        fun bind(film: FilmResponse){
            setViews(film)
        }

        private fun setViews(film: FilmResponse){
           filmName.text = film.title
           director.text = film.director
            producer.text = film.producer
            releaseDate.text = film.releaseDate

        }

    }
}
//     var films: List<FilmModel> = listOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFilms {
//        return ViewHolderFilms(inflater.inflate(R.layout.item_film,parent,false))
//    }
//
//    private fun getItem(position:Int): FilmModel = films[position]
//
//    override fun onBindViewHolder(holder: ViewHolderFilms, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    fun refresh(filmsList: List<FilmModel>) {
//        films = filmsList
//        notifyDataSetChanged()
//    }
//
//    override fun getItemCount(): Int = films.size
//
//    inner class ViewHolderFilms(v: View) : RecyclerView.ViewHolder(v){
//        private val filmName: TextView = itemView.findViewById(R.id.film_name)
//        private val director: TextView = itemView.findViewById(R.id.director)
//        private val producer: TextView = itemView.findViewById(R.id.producer)
//        private val releaseDate: TextView = itemView.findViewById(R.id.releaseDate)
//
//        fun bind(film: FilmModel){
//            setViews(film)
//        }
//
//        private fun setViews(film: FilmModel){
//           filmName.text = film.title
//           director.text = film.director
//            producer.text = film.producer
//            releaseDate.text = film.releaseDate
//
//        }
//
//    }


