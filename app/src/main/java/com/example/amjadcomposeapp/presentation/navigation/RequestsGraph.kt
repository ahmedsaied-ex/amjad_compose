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
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.RequestDetailsScreen
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.RequestsScreen
import com.example.amjadcomposeapp.presentation.viewModel.RequestsViewModel


fun NavGraphBuilder.requestsGraph(navController: NavHostController) {

    composable(AppRoute.Requests::class.qualifiedName!!) { backStackEntry ->
        val viewModel: RequestsViewModel = hiltViewModel(backStackEntry)
        RequestsScreen(navController = navController, viewModel = viewModel)
    }

    composable(AppRoute.RequestDetails::class.qualifiedName!!) { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(AppRoute.Requests::class.qualifiedName!!)
        }
        val viewModel: RequestsViewModel = hiltViewModel(parentEntry)

        val selectedRequest by viewModel.selectedRequest.collectAsState()
        if (selectedRequest != null) {
            RequestDetailsScreen(navController = navController, item = selectedRequest!!)
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No Request Selected")
            }
        }
    }

}
