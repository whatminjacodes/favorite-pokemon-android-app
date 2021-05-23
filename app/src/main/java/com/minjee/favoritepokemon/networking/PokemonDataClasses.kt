package com.minjee.favoritepokemon.networking

data class Response(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonList>
)

data class PokemonList(
    val name: String,
    val url: String
)