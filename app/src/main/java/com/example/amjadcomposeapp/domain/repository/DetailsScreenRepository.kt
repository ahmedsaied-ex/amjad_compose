package com.example.amjadcomposeapp.domain.repository

import com.example.amjadcomposeapp.domain.models.EmojisModel

interface DetailsScreenRepository {
    suspend fun getEmojis():List<EmojisModel>
}