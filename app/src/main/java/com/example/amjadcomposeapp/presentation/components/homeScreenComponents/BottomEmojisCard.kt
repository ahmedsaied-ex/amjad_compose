package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.amjadcomposeapp.domain.models.BottomBarEmojis
import com.example.amjadcomposeapp.helpers.UiState

@Composable
fun ParentScreen(  emojis : UiState<List<BottomBarEmojis>> ) {
    when(emojis) {
        is UiState.Success->{
            var showBox by remember { mutableStateOf(true) }
            if (showBox) {
                BottomBarContent( emojisList = emojis.data ,onClose = { showBox = false })
            }
        }else -> {}
    }
}
