package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.AssessmentCardModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetAssessments @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke(): List<AssessmentCardModel> {
        return repository.getAssessments()
    }
}