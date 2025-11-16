package com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CalenderAttendanceAndWithdrawal
import com.example.amjadcomposeapp.ui.theme.CalenderAttendanceAndWithdrawalBackground
import com.example.amjadcomposeapp.ui.theme.CalenderAttendanceTimeColor
import com.example.amjadcomposeapp.ui.theme.CalenderWithdrawalTimeColor


@Composable
fun AttendanceAndWithdrawalRow() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
        ) {
            AttendanceAndWithdrawText(stringResource(R.string.attendance_time_title))
            Spacer(modifier = Modifier.weight(1f))
            AttendanceAndWithdrawText(stringResource(R.string.withdrawal_text_title))
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(CalenderAttendanceAndWithdrawalBackground)
                .fillMaxWidth()
                .padding(10.dp)


        ) {
            Row (verticalAlignment = Alignment.CenterVertically){
                AttendanceTimeText(
                    text = "9:59",
                    color = CalenderAttendanceTimeColor,
                    fontWeight = FontWeight.SemiBold,
                )
                AttendanceTimeText(
                    text = " ص ",
                    color = CalenderAttendanceTimeColor,
                    fontWeight = FontWeight.Light
                )
                Image(painter = painterResource(R.drawable.edit), contentDescription = "edit button")
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                AttendanceTimeText(
                    text = "4:50",
                    color =CalenderWithdrawalTimeColor,
                    fontWeight = FontWeight.SemiBold,
                )
                AttendanceTimeText(
                    text = " م ",
                    color = CalenderWithdrawalTimeColor,
                    fontWeight = FontWeight.Light
                )
                Image(painter = painterResource(R.drawable.edit), contentDescription = "edit button")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun AttendanceTimeText(text: String, color: Color, fontWeight: FontWeight) {
    Text(
        text, style = TextStyle(
            fontWeight = fontWeight,
            fontSize = 14.sp,
            fontFamily = Alexandria,
            color = color
        )
    )
}

@Composable
fun AttendanceAndWithdrawText(text: String) {
    Text(
        text, style = TextStyle(
            fontFamily = Alexandria,
            fontWeight = FontWeight.Light,
            fontSize = 11.sp,
            color = CalenderAttendanceAndWithdrawal
        )
    )
}


