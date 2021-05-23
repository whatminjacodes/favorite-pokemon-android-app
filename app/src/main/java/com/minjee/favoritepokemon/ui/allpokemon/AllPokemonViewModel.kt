package com.minjee.favoritepokemon.ui.allpokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minjee.favoritepokemon.networking.*
import kotlinx.coroutines.launch

class AllPokemonViewModel(private val poksuRepository: PokemonRepository) : ViewModel() {

    val uiTextLiveData = MutableLiveData<String>()

    fun setText(text: String) {
        uiTextLiveData.postValue(text)
    }

    fun getPokemon() {
       /* CoroutineScope(Dispatchers.IO).launch {
            val pokemonResponse = poksuRepository.getPoksu(PokemonRequest(5))
            //TODO: general error handling
            val viewItems = pokemonResponse.map { pokemon ->
                Log.d("test", pokemon)
            }
            withContext(Dispatchers.Main) {
               // testRecyclerViewItems.postValue(viewItems)
            }
        }*/
    }

    val myResponseList: MutableLiveData<Response> = MutableLiveData()


    fun getPosts() {
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
            myResponseList.value = UserNetwork.retrofit.getPosts(5)
        }
    }
}