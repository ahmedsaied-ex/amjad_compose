package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.HrRequestModel

interface HrRequestsDataSource {
    suspend fun getHrRequests(): List<HrRequestModel>
}