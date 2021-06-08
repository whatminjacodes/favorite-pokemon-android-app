package com.minjee.favoritepokemon.ui.pokemon.details

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name : String ="",
    val email : String= "",
    val password : String =""

) : Parcelable