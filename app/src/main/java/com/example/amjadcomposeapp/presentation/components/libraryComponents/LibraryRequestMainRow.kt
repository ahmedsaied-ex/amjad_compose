package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.amjadcomposeapp.domain.models.MediaModel

@Composable
fun LibraryRequestMainRow(
    item: MediaModel,
    expanded: Boolean,
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
                    Alignment.CenterVertically)
        )
    }
}