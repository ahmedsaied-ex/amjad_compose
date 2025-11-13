package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.delay

@Composable
fun TrackProgress(exoPlayer: ExoPlayer, onProgress: (current: Long, duration: Long) -> Unit) {
    LaunchedEffect(exoPlayer) {
        while (true) {
            onProgress(exoPlayer.currentPosition, exoPlayer.duration.coerceAtLeast(0L))
            delay(500L)
        }
    }
}
