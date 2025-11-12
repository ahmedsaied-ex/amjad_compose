package com.example.amjadcomposeapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.amjadcomposeapp.presentation.components.calendarScreen.CustomCalendar

fun NavGraphBuilder.calenderGraph(navController: NavHostController) {
    composable(AppRoute.Calendar::class.qualifiedName!!) {

        CustomCalendar(navController)
    }
}
