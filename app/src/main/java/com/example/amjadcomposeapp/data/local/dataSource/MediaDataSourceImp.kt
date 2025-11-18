package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.MediaModel
import javax.inject.Inject

class MediaDataSourceImp @Inject constructor() : MediaDataSource {
    override suspend fun getMedia(): List<MediaModel> {
        return DummyData.mediaRequests
    }

}
