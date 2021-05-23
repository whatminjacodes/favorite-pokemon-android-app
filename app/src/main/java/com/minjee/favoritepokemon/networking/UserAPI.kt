package com.minjee.favoritepokemon.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPI {

    @GET("api/v2/pokemon")
    suspend fun getPosts(@Query("limit") maxPokemon: Int): Response
}