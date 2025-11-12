package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.AssessmentCardModel
import javax.inject.Inject

class AssessmentCardDataSourceImp @Inject constructor() :AssessmentCardDataSource {
    override suspend fun getAssessmentCards(): List<AssessmentCardModel> {
        return DummyData.assessmentsList
    }
}