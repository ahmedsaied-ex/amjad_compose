package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents.AudioPlayerUI
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents.ObserveLifecycle
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents.TrackProgress
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents.rememberAudioPlayer
@Composable
fun AudioPlayer(audioUrl: String, title: String) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val exoPlayer = rememberAudioPlayer(context, audioUrl)

    var isPlaying by remember { mutableStateOf(false) }
    var lastPosition by rememberSaveable { mutableStateOf(0L) }
    var currentPosition by remember { mutableStateOf(0L) }
    var duration by remember { mutableStateOf(0L) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    ObserveLifecycle(exoPlayer, lifecycleOwner, isPlaying) { lastPosition = it }

    TrackProgress(exoPlayer) { pos, dur ->
        currentPosition = pos
        duration = dur
    }

    AudioPlayerUI(
        title = title,
        isPlaying = isPlaying,
        currentPosition = currentPosition,
        duration = duration,
        errorMessage = errorMessage,
        onPlayPause = {
            try {
                if (exoPlayer.isPlaying) {
                    exoPlayer.pause()
                    isPlaying = false
                } else {
                    exoPlayer.play()
                    isPlaying = true
                }
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessage = "Playback error: ${e.localizedMessage}"
            }
        },
        onSeek = { fraction ->
            try {
                val seekPosition = (fraction * duration).toLong()
                exoPlayer.seekTo(seekPosition)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessage = "Seek failed: ${e.localizedMessage}"
            }
        }
    )
}

fun formatMillis(millis: Long): String {
    val totalSeconds = (millis / 1000).coerceAtLeast(0L) // avoid negative
    val seconds = totalSeconds % 60
    val minutes = totalSeconds / 60
    return "%02d:%02d".format(minutes, seconds)
}