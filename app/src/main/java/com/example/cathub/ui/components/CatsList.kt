package com.example.cathub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cathub.model.Cat
import com.example.cathub.ui.components.utils.SnackbarController
//import com.example.cathub.ui.screens.feed.ArticleListEvent
import kotlinx.coroutines.launch

@Composable
fun CatsList(
    padding: PaddingValues,
    cats: List<Cat>,
//    onChangeRecipeScrollPosition: (Int) -> Unit,
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
        LazyColumn {
            itemsIndexed(
                items = cats
            ) { index, cat ->
                CatCard(
                    cat = cat,
                    onClick = {
//                        if (article.id != null) {
//                            val bundle = Bundle()
//                            bundle.putInt("recipeId", article.id)
//                            navController.navigate(R.id.viewRecipe, bundle)
//                        } else {
                        snackbarController.getScope().launch {
                            snackbarController.showSnackbar(
                                scaffoldState = scaffoldState,
                                message = "Recipe Error",
                                actionLabel = "OK"
                            )
//                            }
                        }
                    }
                )
            }
        }
    }
}