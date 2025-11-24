package com.example.amjadcomposeapp.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import com.example.amjadcomposeapp.presentation.components.homeScreenComponents.MainScreen

fun NavGraphBuilder.bottomNavGraph(navController: NavHostController) {
    composable<AppRoute.Home>{
        MainScreen(navController = navController)
    }
    composable<AppRoute.Offers> {
        BackHandler {
            // أول ما يدوس Back يرجعه للهوم
            navController.navigate(AppRoute.Home) {
                popUpTo(AppRoute.Home) { inclusive = false }
                launchSingleTop = true
            }
        }

        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Offers Screen")
        }
    }
    composable<AppRoute.Vendors>{
        BackHandler {
            // أول ما يدوس Back يرجعه للهوم
            navController.navigate(AppRoute.Home) {
                popUpTo(AppRoute.Home) { inclusive = false }
                launchSingleTop = true
            }
        }

        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Vendors Screen")
        }
    }
    composable<AppRoute.News> {
        BackHandler {
            // أول ما يدوس Back يرجعه للهوم
            navController.navigate(AppRoute.Home) {
                popUpTo(AppRoute.Home) { inclusive = false }
                launchSingleTop = true
            }
        }

        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("News & Surveys Screen")
        }
    }
    composable<AppRoute.MyConsultant> {
        BackHandler {
            // أول ما يدوس Back يرجعه للهوم
            navController.navigate(AppRoute.Home) {
                popUpTo(AppRoute.Home) { inclusive = false }
                launchSingleTop = true
            }
        }

        Box(modifier = androidx.compose.ui.Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("My Consultant Screen")
        }
    }
}
