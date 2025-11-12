package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.AssessmentCardModel

interface AssessmentCardDataSource {
    suspend fun getAssessmentCards(): List<AssessmentCardModel>
}

