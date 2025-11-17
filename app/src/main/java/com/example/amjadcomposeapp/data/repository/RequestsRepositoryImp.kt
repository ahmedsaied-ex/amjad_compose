package com.example.amjadcomposeapp.data.repository


import com.example.amjadcomposeapp.data.local.dataSource.RequestsDataSource
import com.example.amjadcomposeapp.domain.models.RequestItem
import com.example.amjadcomposeapp.domain.repository.RequestsRepository
import javax.inject.Inject

class RequestsRepositoryImp @Inject constructor(
    private val dataSource: RequestsDataSource
) : RequestsRepository {
    override suspend fun getRequests(): List<RequestItem> {
        return dataSource.getRequests()
    }
}
