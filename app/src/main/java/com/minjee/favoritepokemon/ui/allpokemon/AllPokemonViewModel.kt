package com.minjee.favoritepokemon.ui.allpokemon

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllPokemonViewModel(val resources: Resources) : ViewModel() {

    val uiTextLiveData = MutableLiveData<String>()

    fun setText(text: String) {
        uiTextLiveData.postValue(text)
    }
}