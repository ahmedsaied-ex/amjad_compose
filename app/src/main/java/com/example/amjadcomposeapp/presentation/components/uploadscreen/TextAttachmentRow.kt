package com.example.amjadcomposeapp.presentation.components.uploadscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun TextAttachmentRow(title: String, value: String, titleColor: Color, valueColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,

        ) {
        Text(
            title, style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Normal,
                fontSize = 11.sp,
                color = titleColor
            )
        )
        Text(
            value, style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                color = valueColor
            )
        )
    }
}