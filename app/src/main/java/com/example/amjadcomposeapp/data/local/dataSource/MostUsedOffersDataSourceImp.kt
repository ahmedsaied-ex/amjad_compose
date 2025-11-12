package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.MostUsedOfferModel
import javax.inject.Inject

class MostUsedOffersDataSourceImp @Inject constructor():MostUsedOffersDataSource {
    override suspend fun getMostUsedOffers(): List<MostUsedOfferModel> {
        return DummyData.mostUsedOfferList
    }

}