package com.example.cathub.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cathub.model.Cat

@SuppressLint("DiscouragedApi")
@Composable
fun CatCard(
    cat: Cat,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {
            Image(
                painterResource(LocalContext.current.resources.getIdentifier(cat.image, "drawable", LocalContext.current.packageName)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Cat image"
            )
            Text(
                text = cat.breed,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                    .wrapContentWidth(Alignment.Start),
                style = MaterialTheme.typography.h3
            )
        }
    }
}