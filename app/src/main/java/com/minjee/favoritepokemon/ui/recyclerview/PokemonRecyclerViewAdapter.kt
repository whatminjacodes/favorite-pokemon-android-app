package com.minjee.favoritepokemon.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minjee.favoritepokemon.data.PokemonList
import com.minjee.favoritepokemon.databinding.RecyclerviewItemBinding

class PokemonRecyclerViewAdapter(private val items: List<PokemonList>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PokemonHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PokemonHolder).bind(items[position].name)
    }

    override fun getItemCount() = items.size

    inner class PokemonHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.apply {
                itemName.text = name
            }
            // TODO: add clicklistener
           // binding.root.setOnClickListener { clickListener(move) }
        }
    }
}