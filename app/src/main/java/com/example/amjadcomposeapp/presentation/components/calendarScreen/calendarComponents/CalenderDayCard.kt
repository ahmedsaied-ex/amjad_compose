package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CalendarColorSelectedDayNumber
import com.example.amjadcomposeapp.ui.theme.CalendarColorText
import com.example.amjadcomposeapp.ui.theme.CalendarColorUnSelectedDayNumber
import com.example.amjadcomposeapp.ui.theme.CalendarItemSelectedBorder
import com.example.amjadcomposeapp.ui.theme.CalendarItemUnSelectedBackground
import com.example.amjadcomposeapp.ui.theme.CalendarItemUnSelectedBorder
import com.example.amjadcomposeapp.ui.theme.CalenderItemSelectedBackground
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun CalendarDayCard(
    date: LocalDate,
    isSelected: Boolean,
    dayFormatter: DateTimeFormatter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(3.dp)
            .size(66.dp)
            .shadow(
                elevation = if (isSelected) 8.dp else 0.dp,        // Real shadow
                shape = RoundedCornerShape(12.dp),
                clip = false                                        // Important: allows shadow to bleed
            )
            .border(
                width = 1.dp,
                color = if (isSelected) CalendarItemSelectedBorder
                else CalendarItemUnSelectedBorder,
                shape = RoundedCornerShape(12.dp)
            )
            ,
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 0.dp,   // We don't want Material3 tint
        shadowElevation = 0.dp   // We control shadow manually above
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().background(
                if (isSelected) CalenderItemSelectedBackground
                else CalendarItemUnSelectedBackground
            ).clickable { onClick() }
        ) {
            Text(
                text = date.format(dayFormatter),
                style = TextStyle(
                    fontSize = 11.sp,
                    color = CalendarColorText,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Alexandria
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = date.dayOfMonth.toString(),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                    color = if (isSelected) CalendarColorSelectedDayNumber
                    else CalendarColorUnSelectedDayNumber,
                    fontFamily = Alexandria
                )
            )
        }
    }
}