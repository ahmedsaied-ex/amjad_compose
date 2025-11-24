package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.components.libraryComponents.HeaderWithBackButton
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.AttendanceStats
import com.example.amjadcomposeapp.ui.theme.BottomColumnBackground
import com.example.amjadcomposeapp.ui.theme.CompanyColor
import com.example.amjadcomposeapp.ui.theme.TopColumnBackground
import kotlinx.coroutines.launch
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
                        TopColumnBackground,
                        BottomColumnBackground
                    )
                )
            )
    ) {
        HeaderWithBackButton(
            title = stringResource(R.string.attendence_records),
            onBackClick = { onBackClick?.invoke() })

        Spacer(modifier = Modifier.height(24.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row {
                Text(
                    selectedDate.format(yearAndMonthFormater) , style = TextStyle(
                        fontSize = 16.sp,
                        color = CompanyColor,
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
                        color = AttendanceStats,
                        fontFamily = Alexandria,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Calendar pager
        CalendarLazyRowCentered(
            days = days,
            selectedDate = selectedDate,
            onDateSelected = onDateSelected,
            dayFormatter = dayFormatter
        )
    }
}

@Composable
fun CalendarLazyRowCentered(
    days: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    dayFormatter: DateTimeFormatter,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val selectedIndex = days.indexOf(selectedDate).takeIf { it >= 0 } ?: 0

    LaunchedEffect(Unit) {
        val screenCenter = listState.layoutInfo.viewportEndOffset / 2
        listState.scrollToItem(
            index = selectedIndex,
            scrollOffset = -screenCenter + 200
        )
    }

    LazyRow(
        state = listState,
        contentPadding = PaddingValues(horizontal = 10.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        itemsIndexed(days) { index, date ->
            val isSelected = date == selectedDate

            CalendarDayCard(
                date = date,
                isSelected = isSelected,
                dayFormatter = dayFormatter,
                onClick = {
                    onDateSelected(date)
                    scope.launch {
                        val screenCenter = listState.layoutInfo.viewportEndOffset / 2
                        listState.animateScrollToItem(
                            index = index,
                            scrollOffset = -screenCenter + 35
                        )
                    }
                },
                modifier = Modifier
                    .drawWithCache { onDrawBehind {} }   // This is the magic line
            )
        }
    }
}