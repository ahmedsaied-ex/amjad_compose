package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import BannerPager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.amjadcomposeapp.presentation.components.PersonalityCard
import com.example.amjadcomposeapp.presentation.components.detailsScreenComponents.WhereToPutYourMoney
import com.example.amjadcomposeapp.presentation.viewModel.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val banners by viewModel.banners.collectAsState()
    val hrRequests by viewModel.hrRequests.collectAsState()
    val assessments by viewModel.assessments.collectAsState()
    val surveys by viewModel.surveys.collectAsState()
    val news by viewModel.news.collectAsState()
    val offersCategory by viewModel.offersCategory.collectAsState()
    val mostUsedOffers by viewModel.mostUsedOffers.collectAsState()
    val bottomSheetItems by viewModel.bottomSheetItems.collectAsState()

    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            containerColor = Color.White,
        ) {
            ConsultantBottomSheetContent(
                bottomSheetItems = bottomSheetItems,
                onClick = {
                    showBottomSheet = false
                },
            )
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) {

        item {
            AppBar(navController)
        }
        item {
            BannerPager(banners = banners,navController=navController)
        }
        item {
            HrCard(navController)
        }
        item {
            HRRequests(hrList = hrRequests, navController = navController)
        }
        item {
            AmjadConsultantCard(onClick = { showBottomSheet = true })
        }
        item {
            Spacer(
                Modifier.height(40.dp)
            )
        }
        item {
            PersonalityCardRow()
        }
        item {
            AssessmentList(assessments = assessments)
        }
        item {
            SurveysList(serves = surveys)
        }
        item {
            NewsList(news = news)
        }
        item {
            WhereToPutYourMoney()
        }
        item {
            OffersCategoryList(offersCategory = offersCategory)
        }
        item {
            MostWantedText()
        }

        item {
            MostUsedOffersList(offers = mostUsedOffers)
        }
        item {
            JobsPanner()
        }

    }
}

@Composable
fun PersonalityCardRow() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        PersonalityCard()
    }
}