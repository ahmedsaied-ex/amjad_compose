package com.example.amjadcomposeapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amjadcomposeapp.domain.models.*
import com.example.amjadcomposeapp.domain.use_case.MainScreenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCases: MainScreenUseCases
) : ViewModel() {

    private val _banners = MutableStateFlow<List<BannerImageModel>>(emptyList())
    val banners: StateFlow<List<BannerImageModel>> = _banners

    private val _hrRequests = MutableStateFlow<List<HrRequestModel>>(emptyList())
    val hrRequests: StateFlow<List<HrRequestModel>> = _hrRequests

    private val _assessments = MutableStateFlow<List<AssessmentCardModel>>(emptyList())
    val assessments: StateFlow<List<AssessmentCardModel>> = _assessments

    private val _surveys = MutableStateFlow<List<SurveysTabsModel>>(emptyList())
    val surveys: StateFlow<List<SurveysTabsModel>> = _surveys

    private val _news = MutableStateFlow<List<NewsModel>>(emptyList())
    val news: StateFlow<List<NewsModel>> = _news

    private val _offersCategory = MutableStateFlow<List<OffersCategoryModel>>(emptyList())
    val offersCategory: StateFlow<List<OffersCategoryModel>> = _offersCategory

    private val _mostUsedOffers = MutableStateFlow<List<MostUsedOfferModel>>(emptyList())
    val mostUsedOffers: StateFlow<List<MostUsedOfferModel>> = _mostUsedOffers

    private val _bottomSheetItems = MutableStateFlow<List<BottomSheetItem>>(emptyList())
    val bottomSheetItems: StateFlow<List<BottomSheetItem>> = _bottomSheetItems

    init {
        loadMainScreenData()
    }

    private fun loadMainScreenData() {
        viewModelScope.launch {
            _banners.value = useCases.getBanners()
            _hrRequests.value = useCases.getHrRequests()
            _assessments.value = useCases.getAssessments()
            _surveys.value = useCases.getSurveys()
            _news.value = useCases.getNews()
            _offersCategory.value = useCases.getOffersCategory()
            _mostUsedOffers.value = useCases.getMostUsedOffers()
            _bottomSheetItems.value = useCases.getBottomSheetItems()
        }
    }
}
