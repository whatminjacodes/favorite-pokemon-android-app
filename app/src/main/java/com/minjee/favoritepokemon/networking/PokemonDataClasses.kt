package com.minjee.favoritepokemon.networking

data class PokemonRequest(
    val maxNum: Int?
)

data class PokemonResponse(
    val pokemon: List<Pokemon>
)

data class Pokemon2(
    val name: String?,
    val url: String
)