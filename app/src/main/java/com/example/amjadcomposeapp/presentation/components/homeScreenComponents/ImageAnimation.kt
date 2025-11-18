package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.amjadcomposeapp.domain.models.BottomBarEmojis
import kotlinx.coroutines.delay

@Composable
fun ImageSlideAnimation(emojisList: List<BottomBarEmojis>) {
    var index by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1500)
            index = (index + 1) % emojisList.size
        }
    }
    AnimatedContent(
        targetState = index,
        transitionSpec = {
            slideInVertically { it } + fadeIn() togetherWith
                    slideOutVertically { -it } + fadeOut()
        }
    ) { i ->
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = emojisList[i].emojis),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}