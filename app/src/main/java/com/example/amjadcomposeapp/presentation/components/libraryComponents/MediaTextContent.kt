package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.domain.models.MediaModel
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

@Composable
fun MediaTextContent(item: MediaModel, expanded: Boolean, modifier: Modifier) {
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

