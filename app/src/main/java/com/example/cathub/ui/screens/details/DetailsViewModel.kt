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
        Log.d(TAG, application.favorites.toString())

        if (application.favorites.contains(cat)) {
            application.removeFromFavorites(cat)
        } else {
            application.addToFavorites(cat)
        }

        Log.d(TAG, application.favorites.toString())
    }
}