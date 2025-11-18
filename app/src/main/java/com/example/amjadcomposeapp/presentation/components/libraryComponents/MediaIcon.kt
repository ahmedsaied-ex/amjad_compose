package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.MediaModel
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.ui.theme.FilterBackground

@Composable
fun MediaIcon(item: MediaModel) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(FilterBackground),
            contentAlignment = Alignment.Center
        ) {
            val icon = when (item.type) {
                MediaType.ARTICLES -> item.thumbnailUrl ?: R.drawable.ic_article
                MediaType.AUDIO -> item.thumbnailUrl ?: R.drawable.ic_audio
                MediaType.VIDEO -> item.thumbnailUrl ?: R.drawable.ic_video
            }
            Image(painter = painterResource(icon), contentDescription = "${item.type} Icon")
        }
    }
}
