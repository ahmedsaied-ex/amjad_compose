package com.example.amjadcomposeapp.presentation.components.calendarScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.AttendanceAndWithdrawalRow
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.AttendanceCalendarSection
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.CalendarGreenText
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.DashedBorderBox
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.RedCalendarRedText
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.SelectedDateText
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.WorkingHours
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun CustomCalendar(navController: NavController) {
    val today = LocalDate.now()
    val days = remember { (-15..15).map { today.plusDays(it.toLong()) } }

    var selectedDate by remember { mutableStateOf(today) }

    // Arabic locale
    val arabicLocale = Locale("ar")
    val dayFormatter = DateTimeFormatter.ofPattern("EEE", arabicLocale)
    val fullDateFormatter = DateTimeFormatter.ofPattern("EEEE، d MMMM yyyy", arabicLocale)
    val yearAndMonth = DateTimeFormatter.ofPattern("MMMM yyyy", arabicLocale)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AttendanceCalendarSection(
            days = days,
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it },
            dayFormatter = dayFormatter,
            yearAndMonthFormater= yearAndMonth,
            onBackClick = { navController.popBackStack() },
        )
        Spacer(modifier = Modifier.height(32.dp))
        SelectedDateText(
            selectedDate = selectedDate, dateFormat = fullDateFormatter
        )
        Spacer(modifier = Modifier.height(16.dp))
        DashedBorderBox(
            modifier = Modifier,
            color = colorResource(R.color.date_color),
            strokeWidth = 1.dp,
            dashLength = 4.dp,
            cornerRadius = 12.dp
        ) {
            WorkingHours()
        }
        Spacer(modifier = Modifier.height(8.dp))
        RedCalendarRedText()
        Spacer(modifier = Modifier.height(8.dp))
        CalendarGreenText()
        Spacer(modifier = Modifier.height(60.dp))
        AttendanceAndWithdrawalRow()


    }
}
