package com.example.feature.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.response.Character
import com.example.feature.R
import com.example.feature.databinding.ItemCharacterBinding

class CharaterAdapter(): RecyclerView.Adapter<CharaterAdapter.CharacterViewHolder>() {

    private var data = ArrayList<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        with(holder){
            binding.characterName.text = data[position].name
            binding.birthDate.text = data[position].birthYear
            binding.gender.text = data[position].gender
        }
    }

    override fun getItemCount() = data.size

    class CharacterViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
            val binding = ItemCharacterBinding.bind(view)
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Film]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(
            oldItem: Character, newItem: Character
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Character, newItem: Character
        ): Boolean {
            return oldItem == newItem
        }
    }


}