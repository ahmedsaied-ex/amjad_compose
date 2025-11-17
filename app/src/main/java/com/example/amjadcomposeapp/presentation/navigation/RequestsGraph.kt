package com.example.amjadcomposeapp.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.RequestDetailsScreen
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.RequestsScreen
import com.example.amjadcomposeapp.presentation.viewModel.RequestsViewModel


fun NavGraphBuilder.requestsGraph(navController: NavHostController) {

    composable<AppRoute.Requests> {
        val viewModel: RequestsViewModel = hiltViewModel()
        RequestsScreen(navController, viewModel)
    }

    composable<AppRoute.RequestDetails> { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(AppRoute.Requests)
        }
        val viewModel: RequestsViewModel = hiltViewModel(parentEntry)
        val selectedRequest by viewModel.selectedRequest.collectAsState()

        RequestDetailsScreen(
            navController = navController,
            item = selectedRequest
        )
    }

}
