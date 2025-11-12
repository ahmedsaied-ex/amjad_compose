package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.EmojisModel
import javax.inject.Inject

class EmojisDataSourceImp @Inject constructor():EmojisDataSource {
    override suspend fun getEmojis(): List<EmojisModel> {
        return DummyData.emojisList
    }
}