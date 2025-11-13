package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.videoPlayerComponents.ObserveVideoLifecycle
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.videoPlayerComponents.VideoPlayerView
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.videoPlayerComponents.rememberVideoPlayer

@Composable
fun VideoPlayer(
    context: Context = LocalContext.current,
    url: String
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val videoUri = Uri.parse(url)

    val exoPlayer = rememberVideoPlayer(context, videoUri)

    var isPlaying by rememberSaveable { mutableStateOf(true) }
    var lastPosition by rememberSaveable { mutableStateOf(0L) }

    ObserveVideoLifecycle(exoPlayer, lifecycleOwner, isPlaying) { lastPosition = it }

    VideoPlayerView(exoPlayer = exoPlayer)
}
