package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.audioScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.formatMillis
import com.example.amjadcomposeapp.ui.theme.SliderRowBackground


@Composable
fun AudioProgressRow(
    isPlaying: Boolean,
    currentPosition: Long,
    duration: Long,
    onPlayPause: () -> Unit,
    onSeek: (Float) -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Row(
            Modifier
                .clip(RoundedCornerShape(7.dp))
                .background(SliderRowBackground)
                .fillMaxWidth()
                .padding(vertical = 9.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlayPauseButton(isPlaying, onPlayPause)
            Spacer(modifier = Modifier.width(15.dp))
            AudioSlider(currentPosition, duration, onSeek, modifier = Modifier.weight(14f))
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "-${formatMillis(duration - currentPosition)}",
                style = TextStyle(
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 12.sp
                ),
                modifier = Modifier.weight(4f)
            )
        }
    }
}

