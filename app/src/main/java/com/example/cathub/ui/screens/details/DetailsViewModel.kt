package com.example.cathub.ui.screens.details

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cathub.BaseApplication
import com.example.cathub.model.Cat
import com.example.cathub.utils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject constructor(
    private val application: BaseApplication
) : ViewModel() {

    fun onFavorite(cat: Cat) {

        if (application.favorites.contains(cat)) {
            application.removeFromFavorites(cat)
        } else {
            application.addToFavorites(cat)
        }
    }

    fun getIsFavorite(cat: Cat): Boolean {

        return application.favorites.contains(cat)
    }
}