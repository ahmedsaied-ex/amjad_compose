package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetOffersCategory @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke():  List<OffersCategoryModel> {
        return repository.getOffersCategory()
    }
}