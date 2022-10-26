package com.example.breakingbad.util

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.breakingbad.R

@Composable
fun LoadImage(
    url: String,
    contentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier = Modifier
) {

    androidx.compose.material3.Surface(
        shape = RoundedCornerShape(12.dp)
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            modifier = modifier,
            contentScale = contentScale,
            placeholder = painterResource(id = R.drawable.ic_placeholder),
            error = painterResource(id= R.drawable.ic_placeholder)
        )
    }
}