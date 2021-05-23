package com.minjee.favoritepokemon.networking

class PokemonRepository(
    val pokemonApi: NetworkApi
) {

    // todo: error handling
    suspend fun getPoksu(pokemonRequest: PokemonRequest) = pokemonApi.getPokemon(pokemonRequest)


}