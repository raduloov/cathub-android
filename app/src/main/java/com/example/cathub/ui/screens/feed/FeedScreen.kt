package com.example.cathub.ui.screens.feed

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cathub.ui.components.CatsList
import com.example.cathub.ui.components.FeedHeader
import com.example.cathub.ui.components.utils.SnackbarController
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun FeedScreen(
    navController: NavHostController
) {

    val viewModel: FeedViewModel = hiltViewModel()
    val cats = viewModel.cats.value

    val scaffoldState = rememberScaffoldState()
    val snackbarController = SnackbarController(GlobalScope)

    Scaffold(
        topBar = {
            FeedHeader()
        },
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState }
    ) { padding ->
            Box {
                CatsList(
                    padding = padding,
                    cats = cats,
                    scaffoldState = scaffoldState,
                    snackbarController = snackbarController,
                    navController = navController
                )
            }
        }
    }