package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.components.libraryComponents.HeaderWithBackButton
import com.example.amjadcomposeapp.ui.theme.Alexandria
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun AttendanceCalendarSection(
    days: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    dayFormatter: DateTimeFormatter,
    modifier: Modifier = Modifier,
    yearAndMonthFormater: DateTimeFormatter,
    onBackClick: (() -> Unit)? = null,
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    bottomStart = 20.dp, bottomEnd = 20.dp
                )
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.top_column_background),
                        colorResource(R.color.bottom_column_background)
                    )
                )
            )
    ) {

        // Header with back button
        HeaderWithBackButton(
            title = stringResource(R.string.attendence_records),
            onBackClick = { onBackClick?.invoke() })

        Spacer(modifier = Modifier.height(24.dp))

        // Month / Stats Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row {
                Text(
                    selectedDate.format(yearAndMonthFormater) , style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(R.color.company_color),
                        fontFamily = Alexandria,
                    )
                )
                Image(
                    painter = painterResource(R.drawable.ic_angle_down),
                    contentDescription = "down arrow"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Image(
                    painter = painterResource(R.drawable.ic_attendance_stats),
                    contentDescription = "attendance stats"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    selectedDate.format(yearAndMonthFormater) , style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(R.color.attendance_stats),
                        fontFamily = Alexandria,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Calendar pager
        CalendarLazyRow(
            days = days,
            selectedDate = selectedDate,
            onDateSelected = onDateSelected,
            dayFormatter = dayFormatter
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}
