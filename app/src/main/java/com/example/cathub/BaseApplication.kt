package com.example.cathub

import android.app.Application
import androidx.compose.runtime.*
import com.example.cathub.model.Cat
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    // should be saved in a database or cache
    var favorites by mutableStateOf(listOf<Cat>())

    fun addToFavorites(cat: Cat) {
        favorites = favorites + cat
    }
}