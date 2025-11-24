package com.example.amjadcomposeapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.amjadcomposeapp.domain.models.AttendanceRecord
import com.example.amjadcomposeapp.domain.repository.AttendanceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AttendanceViewModel @Inject constructor(
    private val repo: AttendanceRepository
) : ViewModel() {

    private val _attendanceList = MutableStateFlow<List<AttendanceRecord>>(emptyList())
    val attendanceList: StateFlow<List<AttendanceRecord>> = _attendanceList

    var selectedDayRecord by mutableStateOf<AttendanceRecord?>(null)
        private set

    fun loadAttendance() {
        val today = LocalDate.now()
        val start = today.minusDays(15)
        val end = today.plusDays(15)

        _attendanceList.value = repo.getAttendanceForRange(start, end)
    }

    fun onDaySelected(date: LocalDate) {
        selectedDayRecord = attendanceList.value.find { it.date == date }
    }
}

