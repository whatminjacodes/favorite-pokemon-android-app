package com.minjee.favoritepokemon.ui.allpokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minjee.favoritepokemon.networking.*
import kotlinx.coroutines.launch

class AllPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    val responseList: MutableLiveData<Response> = MutableLiveData()

    fun getPokemon() {
        /*CoroutineScope(Dispatchers.IO).launch {
            val pokemonResponse = poksuRepository.getPoksu(PokemonRequest(5))
            //TODO: general error handling
            val viewItems = pokemonResponse.map { pokemon ->
                Log.d("test", pokemon)
            }
            withContext(Dispatchers.Main) {
                testRecyclerViewItems.postValue(viewItems)
            }
        }*/

        viewModelScope.launch {
            responseList.value = UserNetwork.retrofit.getPosts(5)
        }
    }
}