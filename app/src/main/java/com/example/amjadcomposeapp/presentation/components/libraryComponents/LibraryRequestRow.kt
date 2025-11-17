package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.presentation.viewModel.MediaViewModel
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.FilterBackground
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

@Composable
fun LibraryRequestRow(
    item: MediaRequest,
    navController: NavController,
    viewModel: MediaViewModel = viewModel()
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                viewModel.selectRequest(item)
                navController.navigate(AppRoute.LibraryContent::class.qualifiedName!!)
            },
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            LibraryRequestMainRow(item, expanded, onExpandClick = { expanded = !expanded })
            ExpandCollapseArrow(expanded = expanded, onClick = { expanded = !expanded })
        }
    }
}

// ---------------------- Main Row ----------------------
@Composable
fun LibraryRequestMainRow(
    item: MediaRequest,
    expanded: Boolean,
    onExpandClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        MediaIcon(item)
        Spacer(modifier = Modifier.width(12.dp))
        MediaTextContent(item = item, expanded = expanded, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(12.dp))
        MediaActionIcon(
            item = item, modifier = Modifier
                .fillMaxHeight()
                .align(
                    Alignment.CenterVertically
                )
        )
    }
}

// ---------------------- Media Icon ----------------------
@Composable
fun MediaIcon(item: MediaRequest) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(FilterBackground),
            contentAlignment = Alignment.Center
        ) {
            val icon = when (item.type) {
                MediaType.ARTICLES -> item.thumbnailUrl ?: R.drawable.ic_article
                MediaType.AUDIO -> item.thumbnailUrl ?: R.drawable.ic_audio
                MediaType.VIDEO -> item.thumbnailUrl ?: R.drawable.ic_video
            }
            Image(painter = painterResource(icon), contentDescription = "${item.type} Icon")
        }
    }
}

// ---------------------- Media Text Content ----------------------
@Composable
fun MediaTextContent(item: MediaRequest, expanded: Boolean, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = item.title,
            style = TextStyle(
                fontFamily = Alexandria,
                color = MainColorYankies,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = item.description,
            maxLines = if (expanded) Int.MAX_VALUE else 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontFamily = Alexandria,
                color = DateColor,
                fontSize = 11.sp
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        MediaDate()
    }
}

@Composable
fun MediaDate() {
    Row {
        Text(
            text = "متوفر حتى:",
            style = TextStyle(
                fontFamily = Alexandria,
                color = DateColor,
                fontSize = 11.sp
            )
        )
        Text(
            text = " 5 ابريل 2025 ",
            style = TextStyle(
                fontFamily = Alexandria,
                color = MainColorYankies,
                fontSize = 11.sp
            )
        )
    }
}

// ---------------------- Media Action Icon ----------------------
@Composable
fun MediaActionIcon(item: MediaRequest, modifier: Modifier) {
    if (item.type != MediaType.ARTICLES) {
        Box(
            modifier = modifier
                .size(28.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_play),
                contentDescription = "Play Icon"
            )
        }
    }
}

// ---------------------- Expand / Collapse Arrow ----------------------
@Composable
fun ExpandCollapseArrow(expanded: Boolean, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(if (expanded) R.drawable.ic_collapse else R.drawable.ic_expand),
            contentDescription = "expand arrows",
            modifier = Modifier.clickable { onClick() }
        )
    }
}
