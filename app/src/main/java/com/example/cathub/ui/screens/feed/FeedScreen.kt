package com.example.cathub.ui.screens.feed

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cathub.ui.components.CatsList
import com.example.cathub.ui.components.FeedHeader
import com.example.cathub.ui.components.SearchBar
import kotlinx.coroutines.delay

@Composable
fun FeedScreen(
    navController: NavHostController
) {

    val viewModel: FeedViewModel = hiltViewModel()
    val cats = viewModel.cats.value

    val scaffoldState = rememberScaffoldState()
    val isLoading = remember { mutableStateOf(true) }

    // Mock loading effect
    LaunchedEffect(Unit) {
        delay(1500)
        isLoading.value = false
    }

    Scaffold(
        topBar = {
            Column {
                FeedHeader()
                SearchBar(
                    query = viewModel.query.value,
                    onQueryChanged = viewModel::onQueryChanged,
                    onSearch = viewModel::onSearch
                )
            }
        },
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (isLoading.value) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .progressSemantics()
                        .size(100.dp)
                )
            } else {
                CatsList(
                    padding = padding,
                    cats = cats,
                    navController = navController
                )
            }
          }
        }
    }