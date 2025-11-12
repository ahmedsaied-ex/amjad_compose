package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun RedCalendarRedText() {
    Row(
        modifier = Modifier
            .background(
                color = colorResource(R.color.calender_red_text_background),
                shape = RoundedCornerShape(22.dp)
            )
            .border(
                width = 1.dp,
                color = colorResource(R.color.calender_red_text_border),
                shape = RoundedCornerShape(22.dp)
            )
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CalendarRedText("الوقت المتبقي لإكمال ساعات العمل:")
        CalendarRedNumber(" 1 ")
        CalendarRedText("ساعه و ")
        CalendarRedNumber(" 9 ")
        CalendarRedText("دقائق ")
    }
}


@Composable
fun CalendarRedNumber(text: String) {
    Text(
        text, style = TextStyle(
            fontSize = 16.sp,
            color = colorResource(R.color.calender_red_text),
            fontWeight = FontWeight.Medium,
            fontFamily = Alexandria
        )
    )
}

@Composable
fun CalendarRedText(text: String) {
    Text(
        text, style = TextStyle(
            fontSize = 11.sp,
            color = colorResource(R.color.calender_red_text),
            fontWeight = FontWeight.Normal,
            fontFamily = Alexandria
        )
    )
}

