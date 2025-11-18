package com.example.amjadcomposeapp.data.repository

import com.example.amjadcomposeapp.data.local.dataSource.MediaDataSource
import com.example.amjadcomposeapp.domain.models.MediaModel
import com.example.amjadcomposeapp.domain.repository.MediaRepository
import javax.inject.Inject


class MediaRepositoryImpl @Inject constructor(
    private val dataSource: MediaDataSource
) : MediaRepository {
    override suspend fun getMedia(): List<MediaModel> {
        return dataSource.getMedia()
    }
}