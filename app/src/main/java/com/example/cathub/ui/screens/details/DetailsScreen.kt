package com.example.cathub.ui.screens.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cathub.model.Cat

@Composable
fun DetailsScreen(
    navController: NavController,
    breed: String?,
    image: String?,
    description: String?
) {
    description?.let {
        Text(text = it)
    }
}