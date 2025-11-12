package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import javax.inject.Inject

class OfferCategoryDataSourceImp @Inject constructor():OfferCategoryDataSource {
    override suspend fun getOfferCategory(): List<OffersCategoryModel> {
        return DummyData.offerCategoryList
    }
}