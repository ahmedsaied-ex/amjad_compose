package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.MostUsedOfferModel

interface MostUsedOffersDataSource {
    suspend fun getMostUsedOffers(): List<MostUsedOfferModel>
}


