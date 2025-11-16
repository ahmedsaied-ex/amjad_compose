package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CalendarLazyRow(
    days: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    dayFormatter: DateTimeFormatter,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val initialIndex = days.indexOf(selectedDate).takeIf { it >= 0 } ?: 0

    LaunchedEffect(Unit) {
        listState.scrollToItem(initialIndex)
    }

    LazyRow(
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        itemsIndexed(days) { index, date ->
            val isSelected = date == selectedDate
            CalendarDayCard(
                date = date, isSelected = isSelected, dayFormatter = dayFormatter, onClick = {
                    onDateSelected(date)
                    scope.launch {
                        listState.animateScrollToItem(index)
                    }
                })
        }
    }
}
