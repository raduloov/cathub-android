package com.example.cathub.ui.screens.feed

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cathub.BaseApplication
import com.example.cathub.model.Cat
import com.example.cathub.utils.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class FeedViewModel
@Inject constructor(
    private val application: BaseApplication
) : ViewModel() {

    val cats: MutableState<List<Cat>> = mutableStateOf(ArrayList())

    init {
        cats.value = getCats()
    }

    private fun getCats(): List<Cat> {
        val jsonFileString = getJsonDataFromAsset(application.applicationContext, "data.json")
        val gson = Gson()
        val listPersonType = object : TypeToken<List<Cat>>() {}.type
        return gson.fromJson(jsonFileString, listPersonType)
    }
}