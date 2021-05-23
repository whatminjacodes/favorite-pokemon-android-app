package com.minjee.favoritepokemon.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserNetwork {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }
}