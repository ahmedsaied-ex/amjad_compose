package com.example.amjadcomposeapp.data.repository

import com.example.amjadcomposeapp.data.local.dataSource.EmojisDataSource
import com.example.amjadcomposeapp.data.local.dataSource.EmojisDataSourceImp
import com.example.amjadcomposeapp.domain.models.EmojisModel
import com.example.amjadcomposeapp.domain.repository.DetailsScreenRepository
import javax.inject.Inject

class DetailsScreenRepositoryImp @Inject constructor(private val dataSourceImp: EmojisDataSource): DetailsScreenRepository {
    override suspend fun getEmojis(): List<EmojisModel> {
        return dataSourceImp.getEmojis()
    }

}