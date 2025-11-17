package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

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
