package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.HrRequestModel
import javax.inject.Inject

class HrRequestsDataSourceImp @Inject constructor():HrRequestsDataSource {
    override suspend fun getHrRequests(): List<HrRequestModel> {
        return DummyData.HrRequestList
    }
}