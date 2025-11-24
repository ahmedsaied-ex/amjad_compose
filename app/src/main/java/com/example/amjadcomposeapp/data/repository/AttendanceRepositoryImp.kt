package com.example.amjadcomposeapp.data.repository

import com.example.amjadcomposeapp.domain.models.AttendanceRecord
import com.example.amjadcomposeapp.domain.repository.AttendanceRepository
import java.time.LocalDate
import java.time.LocalTime
import javax.inject.Inject

class AttendanceRepositoryImp @Inject constructor(): AttendanceRepository {
    override fun getAttendanceForRange(
        start: LocalDate,
        end: LocalDate
    ): List<AttendanceRecord> {
        return generateSequence(start) { it.plusDays(1) }
            .takeWhile { !it.isAfter(end) }
            .map { date ->


                if (date.dayOfWeek.value == 5 || date.dayOfWeek.value == 6 ) {
                    AttendanceRecord(date, null, null)
                } else {
                    // random مثال
                    val checkIn = LocalTime.of(9, (0..59).random())
                    val checkOut = if (date == LocalDate.now()) null // النهارده لسه ما مشيش
                    else checkIn.plusHours(9)
                        .minusMinutes((0..120).random().toLong()) // ممكن يمشي بدري

                    AttendanceRecord(
                        date = date,
                        checkIn = checkIn,
                        checkOut = checkOut
                    )
                }
            }.toList()
    }
}
