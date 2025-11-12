package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.RequestItem
import javax.inject.Inject

class RequestsDataSourceImp @Inject constructor(): RequestsDataSource {
    override suspend fun getRequests(): List<RequestItem> {
        return DummyData.RequestItems
    }
}