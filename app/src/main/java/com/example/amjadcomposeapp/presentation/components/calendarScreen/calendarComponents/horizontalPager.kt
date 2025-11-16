package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun CalendarPager(
    days: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    dayFormatter: DateTimeFormatter,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val initialPage = days.indexOf(selectedDate).takeIf { it >= 0 } ?: 0
    val pagerState = rememberPagerState(initialPage = initialPage, pageCount = { days.size })

    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(70.dp),
        contentPadding = PaddingValues(horizontal = 120.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) { page ->
        val date = days[page]
        val isSelected = date == selectedDate

        CalendarDayCard(
            date = date, isSelected = isSelected, dayFormatter = dayFormatter, onClick = {
                onDateSelected(date)
                scope.launch {
                    pagerState.animateScrollToPage(page)
                }
            }
        )
    }
}
