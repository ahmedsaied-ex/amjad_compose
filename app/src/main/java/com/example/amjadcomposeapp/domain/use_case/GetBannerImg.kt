package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.BannerImageModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetBannerImg  @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke(): List<BannerImageModel> {
        return repository.getBannerImg()
    }
}