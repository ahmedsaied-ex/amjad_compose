package com.example.amjadcomposeapp.domain.repository

import com.example.amjadcomposeapp.domain.models.AttendanceRecord
import java.time.LocalDate

interface AttendanceRepository {
    fun getAttendanceForRange(
        start: LocalDate,
        end: LocalDate
    ): List<AttendanceRecord>
}