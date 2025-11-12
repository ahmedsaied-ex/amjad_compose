package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType
import javax.inject.Inject

class MediaDataSourceImp @Inject constructor() : MediaDataSource {
    override suspend fun getMedia(): List<MediaRequest> {
        return DummyData.mediaRequests
    }

}
