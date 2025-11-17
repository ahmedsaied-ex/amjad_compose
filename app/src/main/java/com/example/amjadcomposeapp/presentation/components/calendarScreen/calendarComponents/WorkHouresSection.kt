package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor


@Composable
fun WorkingHours() {
    Row(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "أوقات بدء الدوام:", style = TextStyle(
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Alexandria,
                color = DateColor
            )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            "8:00",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Alexandria,
            color = DateColor
        )
        Text(
            "صباحاً",
            fontSize = 11.sp,
            fontWeight = FontWeight.Light,
            fontFamily = Alexandria,
            color = DateColor
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            ":",
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = Alexandria,
            color = DateColor
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            "10:00",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Alexandria,
            color = DateColor
        )
        Text(
            "صباحاً",
            fontSize = 11.sp,
            fontWeight = FontWeight.Light,
            fontFamily = Alexandria,
            color =DateColor
        )

    }
}




