package com.example.amjadcomposeapp.domain.repository

import com.example.amjadcomposeapp.domain.models.MediaModel

interface MediaRepository {
    suspend fun getMedia():List<MediaModel>
}