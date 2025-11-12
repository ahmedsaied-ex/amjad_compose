package com.example.amjadcomposeapp.domain.repository

import com.example.amjadcomposeapp.domain.models.RequestItem

interface RequestsRepository {
    suspend fun getRequests(): List<RequestItem>
}