package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.BannerImageModel
import javax.inject.Inject

class BannerDataSourceImp @Inject constructor():BannerDataSource {
    override suspend fun getBanners(): List<BannerImageModel> {
        return DummyData.bannerList
    }
}