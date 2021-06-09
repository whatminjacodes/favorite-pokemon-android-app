package com.minjee.favoritepokemon.application

import com.minjee.favoritepokemon.data.NetworkApi
import com.minjee.favoritepokemon.data.PokemonRepository
import com.minjee.favoritepokemon.ui.favorites.firstTeam.FirstTeamTabViewModel
import com.minjee.favoritepokemon.ui.pokemon.PokemonViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { FirstTeamTabViewModel(get()) }
    viewModel { PokemonViewModel(get()) }
    single { PokemonRepository(get()) }
}

val networkingModule = module {
    single { createRetrofit(createOkHttpClient()) }
    single { createNetworkApi(get()) }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://pokeapi.co/")
        .client(okHttpClient)
        .build()
}

fun createNetworkApi(retrofit: Retrofit): NetworkApi {
    return retrofit.create(NetworkApi::class.java)
}