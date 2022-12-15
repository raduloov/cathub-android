package com.example.cathub.ui.screens.details

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cathub.model.Cat
import com.example.cathub.utils.WIKIPEDIA_URL

@SuppressLint("DiscouragedApi")
@Composable
fun DetailsScreen(
    navController: NavController,
    breed: String,
    image: String,
    description: String,
    url: String
) {

    val viewModel: DetailsViewModel = hiltViewModel()

    val showSuccessDialog = remember { mutableStateOf(false) }
    val showRemoveDialog = remember { mutableStateOf(false) }

    val cat = Cat(breed, image, description, url)
    val isFavorite = viewModel.getIsFavorite(cat)

    val context = LocalContext.current

    val intent = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse("$WIKIPEDIA_URL${cat.urlSuffix}"))
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
            ) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = "Back button",
                    modifier = Modifier
                        .size(50.dp)
                )
            }
            Spacer(modifier = Modifier)
            IconButton(
                onClick = {
                    if (isFavorite) {
                        showRemoveDialog.value = true
                    } else {
                        viewModel.onFavorite(cat)
                        showSuccessDialog.value = true
                    }
                }
            ) {
                if (isFavorite) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        tint = Color.Red,
                        contentDescription = "Back button",
                        modifier = Modifier
                            .size(40.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        tint = Color.Gray,
                        contentDescription = "Back button",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
        }
        Image(
            painterResource(LocalContext.current.resources.getIdentifier(image, "drawable", LocalContext.current.packageName)),
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            contentDescription = "Cat image"
        )
        Text(
            text = breed,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                .wrapContentWidth(Alignment.Start),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                .wrapContentWidth(Alignment.Start),
            style = MaterialTheme.typography.h5
        )
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = { context.startActivity(intent) }
        ) {
            Text(text = "Show more info")
        }

        if (showSuccessDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    showSuccessDialog.value = false
                },
                title = {
                    Text(text = "Successfully added $breed to favorites!")
                },
                confirmButton = {  },
                dismissButton = {
                    Button(
                        onClick = {
                            showSuccessDialog.value = false
                        }) {
                        Text("Great!")
                    }
                }
            )
        }

        if (showRemoveDialog.value) {
            AlertDialog(
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.onFavorite(cat)
                            showRemoveDialog.value = false
                        }) {
                        Text("Yes")
                    }
                },
                onDismissRequest = {
                    showRemoveDialog.value = false
                },
                title = {
                    Text(text = "Are you sure you want to remove $breed from favorites?")
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showRemoveDialog.value = false
                        }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}