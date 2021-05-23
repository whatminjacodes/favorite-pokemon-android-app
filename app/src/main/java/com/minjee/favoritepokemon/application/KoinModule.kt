package com.minjee.favoritepokemon.application

import com.google.gson.GsonBuilder
import com.minjee.favoritepokemon.BuildConfig
import com.minjee.favoritepokemon.networking.NetworkApi
import com.minjee.favoritepokemon.networking.PokemonRepository
import com.minjee.favoritepokemon.ui.allpokemon.AllPokemonViewModel
import com.minjee.favoritepokemon.utils.Constants
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel { AllPokemonViewModel(get()) }
    //single<NetworkApi> { get<Retrofit>().create(NetworkApi::class.java) }
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
        //.addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(okHttpClient)
        .build()
}

fun createNetworkApi(retrofit: Retrofit): NetworkApi {
    return retrofit.create(NetworkApi::class.java)
}