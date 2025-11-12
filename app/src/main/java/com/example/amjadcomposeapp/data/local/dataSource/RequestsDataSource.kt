package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.RequestItem

interface RequestsDataSource {
    suspend fun getRequests(): List<RequestItem>
}