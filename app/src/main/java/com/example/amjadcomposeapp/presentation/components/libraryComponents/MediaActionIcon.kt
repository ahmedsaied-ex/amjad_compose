package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType

@Composable
fun MediaActionIcon(item: MediaRequest, modifier: Modifier) {
    if (item.type != MediaType.ARTICLES) {
        Box(
            modifier = modifier
                .size(28.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_play),
                contentDescription = "Play Icon"
            )
        }
    }
}
