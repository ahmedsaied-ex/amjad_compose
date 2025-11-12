package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.BottomSheetItem
import javax.inject.Inject

class BottomSheetDataSourceImp @Inject constructor(): BottomSheetDataSource{
    override suspend fun getBottomSheet(): List<BottomSheetItem> {
       return DummyData.bottomSheetItems
    }

}