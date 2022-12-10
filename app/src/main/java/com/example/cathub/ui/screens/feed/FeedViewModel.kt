package com.example.cathub.ui.screens.feed

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cathub.utils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : ViewModel() {

//    val articles: List<Article> = ArrayList()
    val loading = mutableStateOf(false)
    val query = mutableStateOf("")
    val page = mutableStateOf(1)
    private var recipeListScrollPosition = 0

    init {
//        onTriggerEvent(ArticleListEvent.NewSearchEvent)
    }

//    fun onTriggerEvent(event: ArticleListEvent) {
//        viewModelScope.launch {
//            try {
//                when (event) {
//                    is ArticleListEvent.NewSearchEvent -> {
//                        newSearch()
//                    }
//                    is ArticleListEvent.NextPageEvent -> {
//                        nextPage()
//                    }
//                    is ArticleListEvent.RestoreStateEvent -> {
////                        restoreState()
//                    }
//                }
//            } catch (e: Exception) {
//                Log.e(TAG, "onTriggerEvent: Exception $e, ${e.cause}" )
//            }
//        }
//    }
}