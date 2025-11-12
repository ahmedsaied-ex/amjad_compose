package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.MediaRequest

interface MediaDataSource {
    suspend fun getMedia(): List<MediaRequest>
}