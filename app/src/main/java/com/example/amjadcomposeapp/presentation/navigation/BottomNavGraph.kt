package com.example.amjadcomposeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import com.example.amjadcomposeapp.presentation.components.homeScreenComponents.MainScreen

fun NavGraphBuilder.bottomNavGraph(navController: NavHostController) {
    composable(AppRoute.Home::class.qualifiedName!!) {
        MainScreen(navController = navController)
    }
    composable(AppRoute.Offers::class.qualifiedName!!) {
        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Offers Screen")
        }
    }
    composable(AppRoute.Vendors::class.qualifiedName!!) {
        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Vendors Screen")
        }
    }
    composable(AppRoute.News::class.qualifiedName!!) {
        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("News & Surveys Screen")
        }
    }
    composable(AppRoute.MyConsultant::class.qualifiedName!!) {
        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("My Consultant Screen")
        }
    }
}
