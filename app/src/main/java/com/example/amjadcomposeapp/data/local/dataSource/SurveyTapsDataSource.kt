package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.SurveysTabsModel

interface SurveyTapsDataSource {
    suspend fun getSurveysTaps(): List<SurveysTabsModel>
}