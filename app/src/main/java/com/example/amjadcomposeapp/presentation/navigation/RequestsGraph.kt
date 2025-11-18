package com.example.amjadcomposeapp.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.amjadcomposeapp.domain.models.RequestItem
import com.example.amjadcomposeapp.domain.models.RequestStatus
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
            navController, selectedRequest?: RequestItem(
                id = "-1",
                name = "",
                title = "",
                description = "",
                status = RequestStatus.REJECTED,
                titleColor = 0,
                backgroundColor = 0,
                borderColor = 0
            )
        )
    }

}
