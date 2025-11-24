package com.example.amjadcomposeapp.domain.models

import java.time.LocalDate
import java.time.LocalTime

data class AttendanceRecord(
    val date: LocalDate,
    val checkIn: LocalTime?,     // null لو لسه ما حضرش
    val checkOut: LocalTime?,    // null لو لسه ما مشيش
) {
    // الوقت المفترض للانصراف
    val expectedCheckOut: LocalTime?
        get() = checkIn?.plusHours(9)

    // هل الموظف خرج بدري؟
    val leftEarly: Boolean
        get() = checkOut != null && expectedCheckOut != null && checkOut.isBefore(expectedCheckOut)

    // هل الموظف اتأخر في الحضور؟
    val late: Boolean
        get() = checkIn != null && checkIn.isAfter(LocalTime.of(9, 0))
}
