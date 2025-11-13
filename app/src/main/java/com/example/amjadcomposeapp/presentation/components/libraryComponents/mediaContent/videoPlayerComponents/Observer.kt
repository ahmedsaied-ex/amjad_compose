package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.videoPlayerComponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.exoplayer.ExoPlayer


@Composable
fun ObserveVideoLifecycle(
    exoPlayer: ExoPlayer,
    lifecycleOwner: androidx.lifecycle.LifecycleOwner,
    isPlaying: Boolean,
    onPausePositionChanged: (Long) -> Unit
) {
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE, Lifecycle.Event.ON_STOP -> {
                    onPausePositionChanged(exoPlayer.currentPosition)
                    exoPlayer.pause()
                }
                Lifecycle.Event.ON_RESUME -> {
                    exoPlayer.seekTo(exoPlayer.currentPosition)
                    if (isPlaying) exoPlayer.play()
                }
                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            exoPlayer.release()
        }
    }
}
