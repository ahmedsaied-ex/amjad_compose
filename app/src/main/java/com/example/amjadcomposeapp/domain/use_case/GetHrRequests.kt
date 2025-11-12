package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.HrRequestModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetHrRequests  @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke():  List<HrRequestModel> {
        return repository.getHrRequests()
    }
}