package com.example.amjadcomposeapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.amjadcomposeapp.presentation.components.detailsScreenComponents.DetailsScreen

fun NavGraphBuilder.detailsGraph(navController: NavHostController) {
    composable<AppRoute.ProfileDetails> {
            DetailsScreen(navController)
    }
}
