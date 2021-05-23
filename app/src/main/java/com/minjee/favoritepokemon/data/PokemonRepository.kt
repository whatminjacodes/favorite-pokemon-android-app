package com.minjee.favoritepokemon.data

class PokemonRepository(
    private val pokemonApi: NetworkApi
) {
    // todo: error handling
    suspend fun getPokemon(pokemonRequest: PokemonRequest) = pokemonApi.getPokemon(pokemonRequest.numberOfPokemon)
}