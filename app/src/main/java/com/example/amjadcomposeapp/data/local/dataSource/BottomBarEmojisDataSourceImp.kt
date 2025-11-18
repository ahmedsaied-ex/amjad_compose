package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.BottomBarEmojis
import javax.inject.Inject

class BottomBartDataSourceImp @Inject constructor() : BottomBarEmojisDataSource {
    override suspend fun getBottomBarEmojis(): List<BottomBarEmojis> = DummyData.bottomBarEmojis
}