package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.MostUsedOfferModel
import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetMostUsedOffers @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke(): List<MostUsedOfferModel> {
        return repository.getMostUsedOffers()
    }
}