package com.minjee.favoritepokemon.networking

import com.google.gson.annotations.SerializedName

data class User(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)