package com.example.feature.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.paging.NetworkState
import com.example.core.response.Film
import com.example.feature.R
import com.example.feature.databinding.ItemCharacterBinding
import com.example.feature.databinding.ItemFilmBinding
import com.example.feature.ui.detail.CharaterAdapter

class MainAdapter(
    private val retryCallback: () -> Unit,
    private val listener: OnClickListener
) : RecyclerView.Adapter<MainAdapter.FilmViewHolder>() {

    private var films: List<Film> = listOf()


    private var networkState: NetworkState? = null





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        with(holder){
            binding.filmName.text = films[position].title
        }
        holder.itemView.setOnClickListener{
            listener.onClick(films[position])
        }
    }

    override fun getItemCount() = films.size
    class FilmViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val binding = ItemFilmBinding.bind(view)


    }


    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Character]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [Character]
     */
    class OnClickListener(val clickListener:(film: Film) -> Unit) {
        fun onClick(film: Film) = clickListener(film)
    }
}