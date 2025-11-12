package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.BottomSheetItem

interface BottomSheetDataSource {
    suspend fun getBottomSheet(): List<BottomSheetItem>
}