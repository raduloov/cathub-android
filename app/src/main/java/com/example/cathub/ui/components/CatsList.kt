package com.example.cathub.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cathub.model.Cat
import com.example.cathub.navigation.Screens
import com.example.cathub.ui.components.utils.SnackbarController
import com.example.cathub.utils.TAG
//import com.example.cathub.ui.screens.feed.ArticleListEvent
import kotlinx.coroutines.launch

@Composable
fun CatsList(
    padding: PaddingValues,
    cats: List<Cat>,
    scaffoldState: ScaffoldState,
    snackbarController: SnackbarController,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
            .padding(padding)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 60.dp)
        ) {
            itemsIndexed(
                items = cats
            ) { index, cat ->
                CatCard(
                    cat = cat,
                    onClick = {
                        navController.navigate(Screens.Details.withArgs(cat.breed, cat.image, cat.description))
                        snackbarController.getScope().launch {
                            snackbarController.showSnackbar(
                                scaffoldState = scaffoldState,
                                message = "Recipe Error",
                                actionLabel = "OK"
                            )
                        }
                    }
                )
            }
        }
    }
}