package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.RequestItem
import com.example.amjadcomposeapp.domain.repository.RequestsRepository
import javax.inject.Inject

class GetRequestsUseCase @Inject constructor(
    private val repository: RequestsRepository
) {
    suspend operator fun invoke(): List<RequestItem> {
        return repository.getRequests()
    }
}