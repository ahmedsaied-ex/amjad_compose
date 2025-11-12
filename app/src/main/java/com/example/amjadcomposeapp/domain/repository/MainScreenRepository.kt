package com.example.amjadcomposeapp.domain.repository

import com.example.amjadcomposeapp.domain.models.AssessmentCardModel
import com.example.amjadcomposeapp.domain.models.BannerImageModel
import com.example.amjadcomposeapp.domain.models.BottomSheetItem
import com.example.amjadcomposeapp.domain.models.HrRequestModel
import com.example.amjadcomposeapp.domain.models.MostUsedOfferModel
import com.example.amjadcomposeapp.domain.models.NewsModel
import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import com.example.amjadcomposeapp.domain.models.SurveysTabsModel

interface MainScreenRepository {
    suspend fun getBannerImg(): List<BannerImageModel>

    suspend fun getHrRequests() : List<HrRequestModel>

    suspend fun getAssessments(): List<AssessmentCardModel>

    suspend fun getSurveys(): List<SurveysTabsModel>

    suspend fun getNews(): List<NewsModel>

    suspend fun getOffersCategory():List<OffersCategoryModel>

    suspend fun getMostUsedOffers():List<MostUsedOfferModel>
    suspend fun getBottomSheetItems():List<BottomSheetItem>


}



