package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer


@Composable
fun rememberAudioPlayer(context: Context, audioUrl: String): ExoPlayer {
    return remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(audioUrl))
            prepare()
            playWhenReady = false
        }
    }
}
