package com.example.amjadcomposeapp.data.repository

import com.example.amjadcomposeapp.data.local.dataSource.AssessmentCardDataSource
import com.example.amjadcomposeapp.data.local.dataSource.BannerDataSource
import com.example.amjadcomposeapp.data.local.dataSource.BottomBarEmojisDataSource
import com.example.amjadcomposeapp.data.local.dataSource.BottomSheetDataSource
import com.example.amjadcomposeapp.data.local.dataSource.HrRequestsDataSource
import com.example.amjadcomposeapp.data.local.dataSource.MostUsedOffersDataSource
import com.example.amjadcomposeapp.data.local.dataSource.NewsDataSource
import com.example.amjadcomposeapp.data.local.dataSource.OfferCategoryDataSource
import com.example.amjadcomposeapp.data.local.dataSource.SurveyTapsDataSource
import com.example.amjadcomposeapp.domain.models.AssessmentCardModel
import com.example.amjadcomposeapp.domain.models.BannerImageModel
import com.example.amjadcomposeapp.domain.models.BottomBarEmojis
import com.example.amjadcomposeapp.domain.models.BottomSheetItem
import com.example.amjadcomposeapp.domain.models.HrRequestModel
import com.example.amjadcomposeapp.domain.models.MostUsedOfferModel
import com.example.amjadcomposeapp.domain.models.NewsModel
import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import com.example.amjadcomposeapp.domain.models.SurveysTabsModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class MainScreenRepositoryImp @Inject constructor(
    private val assessmentCardDataSource: AssessmentCardDataSource,
    private val bannerImageDataSource: BannerDataSource,
    private val hrRequestDataSource: HrRequestsDataSource,
    private val surveysTabsDataSource: SurveyTapsDataSource,
    private val newsDataSource: NewsDataSource,
    private val offersCategoryDataSource: OfferCategoryDataSource,
    private val mostUsedOffersDataSource: MostUsedOffersDataSource,
    private val bottomSheetDataSource: BottomSheetDataSource,
    private val bottomBarEmojisDataSource: BottomBarEmojisDataSource,


    ) : MainScreenRepository {
    override suspend fun getBannerImg(): List<BannerImageModel> = bannerImageDataSource.getBanners()

    override suspend fun getHrRequests(): List<HrRequestModel> = hrRequestDataSource.getHrRequests()

    override suspend fun getAssessments(): List<AssessmentCardModel> = assessmentCardDataSource.getAssessmentCards()

    override suspend fun getSurveys(): List<SurveysTabsModel> =surveysTabsDataSource.getSurveysTaps()

    override suspend fun getNews(): List<NewsModel> = newsDataSource.getNews()

    override suspend fun getOffersCategory(): List<OffersCategoryModel> = offersCategoryDataSource.getOfferCategory()

    override suspend fun getMostUsedOffers(): List<MostUsedOfferModel> = mostUsedOffersDataSource.getMostUsedOffers()

    override suspend fun getBottomSheetItems(): List<BottomSheetItem> = bottomSheetDataSource.getBottomSheet()

    override suspend fun getBottomBarEmojis(): List<BottomBarEmojis> = bottomBarEmojisDataSource.getBottomBarEmojis()

}