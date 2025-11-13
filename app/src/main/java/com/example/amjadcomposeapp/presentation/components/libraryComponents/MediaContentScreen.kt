package com.example.amjadcomposeapp.presentation.components.libraryComponents

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.Article
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.AudioPlayer
import com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent.VideoPlayer
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.CostumeAppBar
import com.example.amjadcomposeapp.ui.theme.Alexandria
import kotlinx.coroutines.delay

@Composable
fun MediaContentScreen(item: MediaRequest, navController: NavController) {
    when (item.type) {
        MediaType.AUDIO -> AudioPlayer(audioUrl = item.url, title = item.title)
        MediaType.VIDEO -> VideoPlayer(url = item.url)
        MediaType.ARTICLES -> Article(
            url = item.url,
            thumbnailUrl = item.thumbnailUrl,
            navController = navController
        )
    }

}


