package com.example.cathub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cathub.R

@Composable
fun FeedHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(R.mipmap.ic_launcher),
            modifier = Modifier
                .height(80.dp),
            contentDescription = "Logo image",
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Cat Hub",
            style = TextStyle(
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
    }
}
