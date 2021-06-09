package com.minjee.favoritepokemon.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minjee.favoritepokemon.data.PokemonList
import com.minjee.favoritepokemon.databinding.RecyclerviewItemBinding

/*
 *      Recyclerview for displaying a list of Pokemon in Pokemon Fragment
 */
class PokemonRecyclerViewAdapter(
    private val items: List<PokemonList>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PokemonHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PokemonHolder).bind(items[position].name, clickListener)
    }

    override fun getItemCount() = items.size

    inner class PokemonHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, clickListener: (String) -> Unit) {
            binding.apply {
                pokemonName.text = name
            }
            binding.root.setOnClickListener { clickListener(name) }
        }
    }
}