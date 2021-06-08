package com.minjee.favoritepokemon.ui.pokemon.allpokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minjee.favoritepokemon.data.PokemonList
import com.minjee.favoritepokemon.data.PokemonRepository
import com.minjee.favoritepokemon.data.PokemonRequest
import com.minjee.favoritepokemon.data.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllPokemonTabViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    val listOfPokemon: MutableLiveData<List<PokemonList>> = MutableLiveData()

    fun getPokemon() {
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonResponse = pokemonRepository.getPokemon(PokemonRequest(10))
            //TODO: general error handling

            withContext(Dispatchers.Main) {
                listOfPokemon.postValue(pokemonResponse.results)
            }
        }
    }
}
