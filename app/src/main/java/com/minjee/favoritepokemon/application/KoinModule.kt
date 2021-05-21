package com.minjee.favoritepokemon.application

import com.minjee.favoritepokemon.ui.allpokemon.AllPokemonViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
   viewModel { AllPokemonViewModel(androidContext().resources) }
}