package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AudioSlider(currentPosition: Long, duration: Long, onSeek: (Float) -> Unit,modifier: Modifier) {
    Slider(
        value = if (duration > 0) currentPosition / duration.toFloat() else 0f,
        onValueChange = onSeek,
        modifier = modifier
            .height(3.dp),
        colors = SliderDefaults.colors(
            thumbColor = Color.White,
            activeTrackColor = Color.White,
            inactiveTrackColor = Color.White.copy(alpha = 0.1f)
        ),

        )
}