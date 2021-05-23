package com.minjee.favoritepokemon.ui.allpokemon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minjee.favoritepokemon.networking.PokemonRepository
import com.minjee.favoritepokemon.networking.PokemonRequest
import com.minjee.favoritepokemon.networking.User
import com.minjee.favoritepokemon.networking.UserNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    val myResponse: MutableLiveData<User> = MutableLiveData()
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserNetwork.retrofit.getPost()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = UserNetwork.retrofit.getPosts()
        }
    }
}