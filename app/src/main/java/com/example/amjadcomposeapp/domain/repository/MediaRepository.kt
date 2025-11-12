package com.example.amjadcomposeapp.domain.repository

import com.example.amjadcomposeapp.domain.models.MediaRequest

interface MediaRepository {
    suspend fun getMedia():List<MediaRequest>
}