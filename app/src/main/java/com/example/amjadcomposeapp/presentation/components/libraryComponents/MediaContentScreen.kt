package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.amjadcomposeapp.domain.models.MediaModel
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.Article
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.AudioPlayer
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.VideoPlayer

@Composable
fun MediaContentScreen(item: MediaModel, navController: NavController) {
    when (item.type) {
        MediaType.AUDIO -> AudioPlayer(audioUrl = item.url, title = item.title)
        MediaType.VIDEO -> VideoPlayer(url = item.url)
        MediaType.ARTICLES -> Article(
            url = item.url,
            thumbnailUrl = item.thumbnailUrl,
            navController = navController
        )
    }

}


