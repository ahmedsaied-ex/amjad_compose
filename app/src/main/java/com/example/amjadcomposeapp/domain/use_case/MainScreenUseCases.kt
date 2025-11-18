package com.example.amjadcomposeapp.domain.use_case

import javax.inject.Inject

data class MainScreenUseCases @Inject constructor(
    val getBanners: GetBannerImg,
    val getHrRequests: GetHrRequests,
    val getAssessments: GetAssessments,
    val getSurveys: GetSurveysUseCase,
    val getNews: GetNews,
    val getOffersCategory: GetOffersCategory,
    val getMostUsedOffers: GetMostUsedOffers,
    val getBottomSheetItems: GetBottomSheetItems,
    val getBarEmojis: GetEmojis,

)
