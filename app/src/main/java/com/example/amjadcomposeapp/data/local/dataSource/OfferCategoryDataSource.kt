package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.OffersCategoryModel

interface OfferCategoryDataSource {
    suspend fun getOfferCategory():List<OffersCategoryModel>
}