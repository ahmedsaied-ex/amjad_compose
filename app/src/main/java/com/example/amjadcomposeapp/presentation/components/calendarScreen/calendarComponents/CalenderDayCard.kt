package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.amjadcomposeapp.ui.theme.CalendarColorSelectedDayNumber
import com.example.amjadcomposeapp.ui.theme.CalendarColorText
import com.example.amjadcomposeapp.ui.theme.CalendarColorUnSelectedDayNumber
import com.example.amjadcomposeapp.ui.theme.CalendarItemSelectedBackground
import com.example.amjadcomposeapp.ui.theme.CalendarItemSelectedBorder
import com.example.amjadcomposeapp.ui.theme.CalendarItemUnSelectedBackground
import com.example.amjadcomposeapp.ui.theme.CalendarItemUnSelectedBorder
import java.time.LocalDate
import java.time.format.DateTimeFormatter


// -------------------- Single Day Card --------------------
@Composable
fun CalendarDayCard(
    date: LocalDate,
    isSelected: Boolean,
    dayFormatter: DateTimeFormatter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) CalendarItemSelectedBackground
            else CalendarItemUnSelectedBackground
        ),
        modifier = modifier
            .padding(3.dp)
            .size(66.dp)
            .clickable { onClick() },
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) CalendarItemSelectedBorder
            else CalendarItemUnSelectedBorder
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 2.dp else 0.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = date.format(dayFormatter), style = TextStyle(
                    fontSize = 11.sp,
                    color = CalendarColorText,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Alexandria
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = date.dayOfMonth.toString(), style = TextStyle(
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