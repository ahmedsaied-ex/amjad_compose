package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.SurveysTabsModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetSurveysUseCase @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke(): List<SurveysTabsModel> {
        return repository.getSurveys()
    }
}