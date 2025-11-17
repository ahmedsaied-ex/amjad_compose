package com.example.amjadcomposeapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amjadcomposeapp.domain.models.*
import com.example.amjadcomposeapp.domain.use_case.MainScreenUseCases
import com.example.amjadcomposeapp.helpers.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCases: MainScreenUseCases
) : ViewModel() {

    val banners = MutableStateFlow<UiState<List<BannerImageModel>>>(UiState.Loading)
    val hrRequests = MutableStateFlow<UiState<List<HrRequestModel>>>(UiState.Loading)
    val assessments = MutableStateFlow<UiState<List<AssessmentCardModel>>>(UiState.Loading)
    val surveys = MutableStateFlow<UiState<List<SurveysTabsModel>>>(UiState.Loading)
    val news = MutableStateFlow<UiState<List<NewsModel>>>(UiState.Loading)
    val offersCategory = MutableStateFlow<UiState<List<OffersCategoryModel>>>(UiState.Loading)
    val mostUsedOffers = MutableStateFlow<UiState<List<MostUsedOfferModel>>>(UiState.Loading)
    val bottomSheetItems = MutableStateFlow<UiState<List<BottomSheetItem>>>(UiState.Loading)

    init {
        loadMainScreenData()
    }

    private fun <T> loadData(stateFlow: MutableStateFlow<UiState<T>>, block: suspend () -> T) {
        viewModelScope.launch {
            stateFlow.value = UiState.Loading
            try {
                stateFlow.value = UiState.Success(block())
            } catch (e: Exception) {
                stateFlow.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun loadMainScreenData() {
        loadData(banners) { useCases.getBanners() }
        loadData(hrRequests) { useCases.getHrRequests() }
        loadData(assessments) { useCases.getAssessments() }
        loadData(surveys) { useCases.getSurveys() }
        loadData(news) { useCases.getNews() }
        loadData(offersCategory) { useCases.getOffersCategory() }
        loadData(mostUsedOffers) { useCases.getMostUsedOffers() }
        loadData(bottomSheetItems) { useCases.getBottomSheetItems() }
    }
}
