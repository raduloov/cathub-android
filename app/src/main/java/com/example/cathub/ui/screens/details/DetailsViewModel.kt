package com.example.cathub.ui.screens.details

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cathub.BaseApplication
import com.example.cathub.model.Cat
import com.example.cathub.utils.TAG
import com.example.cathub.utils.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject constructor(
    private val application: BaseApplication
) : ViewModel() {

    val isFavorite = mutableStateOf(false)

    init {
//        cats.value = getCats()
    }

    fun addToFavorites(cat: Cat) {
        Log.d(TAG, application.favorites.toString())
        application.addToFavorites(cat)
        Log.d(TAG, application.favorites.toString())
    }
}