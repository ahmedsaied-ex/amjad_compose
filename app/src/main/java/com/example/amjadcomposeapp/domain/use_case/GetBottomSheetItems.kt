package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.BottomSheetItem
import com.example.amjadcomposeapp.domain.models.SurveysTabsModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetBottomSheetItems @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke(): List<BottomSheetItem> {
        return repository.getBottomSheetItems()
    }
}