package com.minjee.favoritepokemon.ui.allpokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minjee.favoritepokemon.data.PokemonRepository
import com.minjee.favoritepokemon.data.PokemonRequest
import com.minjee.favoritepokemon.data.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    val responseList: MutableLiveData<Response> = MutableLiveData()

    fun getPokemon() {
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonResponse = pokemonRepository.getPokemon(PokemonRequest(6))
            //TODO: general error handling

            withContext(Dispatchers.Main) {
                responseList.postValue(pokemonResponse)
            }
        }
    }
}