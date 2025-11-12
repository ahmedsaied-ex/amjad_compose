package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData
import com.example.amjadcomposeapp.presentation.components.PersonalityCard
import com.example.amjadcomposeapp.presentation.components.homeScreenComponents.PointsAndOffers
import com.example.amjadcomposeapp.presentation.viewModel.DetailsScreenViewModel

@Composable

fun DetailsScreen(
    navController: NavController,
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    val emojis by viewModel.emojis.collectAsState()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier.
                background(color = colorResource(R.color.details_background))
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DetailAppBar(navController)
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    TopGroupDetails()
                }
                item {
                    EmotionsBanner(emojis = emojis)
                }
                item {
                    PersonalityCard()
                }
                item {
                    PersonalDataDetails()
                }
                item {
                    PointsAndOffers()
                }
                item {
                    Favourites()
                }
                item {
                    FamilyMembers()
                }
                item {
                   Spacer(modifier = Modifier.height(30.dp))
                }
                item {
                    CustomSingleDetailsStackCard(
                        img = R.drawable.ic_support_tickets,
                        title = stringResource(R.string.technical_support)
                    )
                }
                item {
                   Spacer(modifier = Modifier.height(30.dp))
                }
                item {
                    CustomSingleDetailsStackCard(
                        img = R.drawable.ic_settings_profile,
                        title = stringResource(R.string.settings_profile)
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                }
                item{
                    LogoutCard(
                        item = DetailsRowData(
                            title = stringResource(R.string.logout_profile),
                            image = R.drawable.ic_logout_profile
                        ),
                        onItemClick = {}
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                }
                item {
                    ResignationButton(onClick = {})
                }
                item {
                    Spacer(modifier = Modifier.height(50.dp))
                }


            }
        }
    }
}














