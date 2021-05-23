package com.minjee.favoritepokemon.networking

import com.google.gson.annotations.SerializedName

data class User(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

data class Pokemon(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Results>
)

data class Results(
    val name: String,
    val url: String
)