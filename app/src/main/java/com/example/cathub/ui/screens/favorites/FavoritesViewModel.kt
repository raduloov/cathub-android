package com.example.cathub.ui.screens.favorites

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cathub.BaseApplication
import com.example.cathub.model.Cat
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel
@Inject constructor(
    private val application: BaseApplication
) : ViewModel() {

    val favoriteCats = mutableStateOf(listOf<Cat>())

    init {
        getFavoriteCats()
    }

    private fun getFavoriteCats() {
        favoriteCats.value = application.favorites
    }
}