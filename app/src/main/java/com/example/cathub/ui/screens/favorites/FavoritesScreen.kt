package com.example.cathub.ui.screens.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cathub.ui.components.CatsList
import com.example.cathub.ui.components.FavoritesHeader
import com.example.cathub.ui.components.FeedHeader
import com.example.cathub.ui.components.utils.SnackbarController
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

@Composable
fun FavoritesScreen(
    navController: NavHostController
) {

    val viewModel: FavoritesViewModel = hiltViewModel()

    val scaffoldState = rememberScaffoldState()

    val favoriteCats = viewModel.favoriteCats.value

    Scaffold(
        topBar = {
            FavoritesHeader()
        },
        scaffoldState = scaffoldState,
    ) { padding ->
        Box {
            CatsList(
                padding = padding,
                cats = favoriteCats,
                navController = navController
            )
        }
    }
}