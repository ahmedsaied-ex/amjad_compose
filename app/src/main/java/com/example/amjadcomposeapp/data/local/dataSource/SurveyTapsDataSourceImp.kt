package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.SurveysTabsModel
import javax.inject.Inject

class SurveyTapsDataSourceImp @Inject constructor():SurveyTapsDataSource {
    override suspend fun getSurveysTaps(): List<SurveysTabsModel> {
        return DummyData.surveyTabsList
    }
}