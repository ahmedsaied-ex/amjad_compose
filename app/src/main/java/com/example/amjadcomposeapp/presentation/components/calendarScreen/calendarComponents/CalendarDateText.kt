package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import java.time.LocalDate
import java.time.format.DateTimeFormatter


// -------------------- Selected Date Text --------------------
@Composable
fun SelectedDateText(
    selectedDate: LocalDate,
    dateFormat: DateTimeFormatter,
    modifier: Modifier = Modifier,

    ) {
    Text(
        text = selectedDate.format(dateFormat), style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(R.color.main_color_yankies),
            fontFamily = Alexandria
        )
    )
}