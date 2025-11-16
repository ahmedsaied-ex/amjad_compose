package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.viewModel.MediaFilter
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CompanyColor
import com.example.amjadcomposeapp.ui.theme.FilterBackground
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

@Composable
private fun LibraryFilterChipItem(
    option: MediaFilter, isSelected: Boolean, text: String, onClick: (MediaFilter) -> Unit
) {
    val bgColor = if (isSelected) Color.White else Color.Transparent
    val textColor =
        if (isSelected) CompanyColor else MainColorYankies

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .clickable { onClick(option) }
            .padding(horizontal = 12.dp, vertical = 8.dp)) {
        Text(
            text = text, style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                fontFamily = Alexandria
            )
        )
    }
}

@Composable
fun LibraryFilterBar(
    selected: MediaFilter,
    onSelectedChange: (MediaFilter) -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp)) // هنا نعمل الحواف مستديرة
            .background(FilterBackground)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        LibraryFilterChipItem(
            option = MediaFilter.ARTICLES,
            isSelected = selected == MediaFilter.ARTICLES,
            text = "مقالات"
        ) { onSelectedChange(it) }

        LibraryFilterChipItem(
            option = MediaFilter.AUDIO,
            isSelected = selected == MediaFilter.AUDIO,
            text = "ملفات صوتية"
        ) { onSelectedChange(it) }

        LibraryFilterChipItem(
            option = MediaFilter.VIDEO, isSelected = selected == MediaFilter.VIDEO, text = "فيديو"
        ) { onSelectedChange(it) }

    }
}
