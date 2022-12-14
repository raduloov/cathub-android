package com.example.cathub.ui.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("DiscouragedApi")
@Composable
fun DetailsScreen(
    navController: NavController,
    breed: String,
    image: String,
    description: String
) {
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
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Back button",
                    modifier = Modifier
                        .size(40.dp)
                )
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
    }
}