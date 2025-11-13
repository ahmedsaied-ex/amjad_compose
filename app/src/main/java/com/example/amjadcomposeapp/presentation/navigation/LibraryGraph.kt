package com.example.amjadcomposeapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.amjadcomposeapp.presentation.components.libraryComponents.LibraryScreen
import com.example.amjadcomposeapp.presentation.components.libraryComponents.MediaContentScreen
import com.example.amjadcomposeapp.presentation.viewModel.MediaViewModel

fun NavGraphBuilder.libraryGraph(navController: NavHostController) {
    composable(AppRoute.Library::class.qualifiedName!!) { backStackEntry ->
        val viewModel: MediaViewModel = hiltViewModel(backStackEntry)
        LibraryScreen(navController = navController, viewModel = viewModel)
    }
    composable(AppRoute.LibraryContent::class.qualifiedName!!) { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(AppRoute.Library::class.qualifiedName!!)
        }
        val viewModel: MediaViewModel = hiltViewModel(parentEntry)

        val selectedRequest by viewModel.selectedRequest.collectAsState()
        if (selectedRequest != null) {
            MediaContentScreen(navController = navController, item = selectedRequest!!)
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
