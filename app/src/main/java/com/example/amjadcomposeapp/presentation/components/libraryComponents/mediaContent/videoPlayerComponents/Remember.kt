package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.videoPlayerComponents

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer


@Composable
fun rememberVideoPlayer(context: Context, videoUri: Uri): ExoPlayer {
    return remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUri))
            prepare()
            playWhenReady = true
        }
    }
}