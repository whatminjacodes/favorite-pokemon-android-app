package com.minjee.favoritepokemon.networking

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkApi {
    @GET("/api/v2/pokemon/")
    fun getPokemon(@Query("limit") maxNumberOfPokemon: PokemonRequest): Call<PokemonResponse>

}