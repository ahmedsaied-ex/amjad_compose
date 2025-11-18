package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.MediaModel

interface MediaDataSource {
    suspend fun getMedia(): List<MediaModel>
}