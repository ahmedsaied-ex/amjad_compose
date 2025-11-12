package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable
fun TitleCardText(title:String) {
    Text(
        title, style = TextStyle(
            color = colorResource(R.color.main_color_yankies),
            fontWeight = FontWeight.Medium,
            fontFamily = Alexandria,
            fontSize = 14.sp
        ), modifier = Modifier.padding(bottom = 12.dp).fillMaxWidth()
    )
}