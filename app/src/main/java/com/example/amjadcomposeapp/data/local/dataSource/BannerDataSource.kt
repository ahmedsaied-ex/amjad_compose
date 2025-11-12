package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.BannerImageModel

interface BannerDataSource {

    suspend fun getBanners(): List<BannerImageModel>
}