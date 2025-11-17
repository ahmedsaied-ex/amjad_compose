package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CalenderGreenText
import com.example.amjadcomposeapp.ui.theme.CalenderGreenTextBackground


@Composable
fun CalendarGreenText() {
    Box(
        Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(CalenderGreenTextBackground)
            .padding(vertical = 8.dp, horizontal = 12.dp), contentAlignment = Alignment.Center

    ) {
        Text(
            stringResource(R.string.request_permission), style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 11.sp,
                color = CalenderGreenText
            )
        )
    }
}