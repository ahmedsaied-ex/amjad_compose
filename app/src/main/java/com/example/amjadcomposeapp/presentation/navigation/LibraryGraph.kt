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
    composable<AppRoute.Library> { backStackEntry ->
        val viewModel: MediaViewModel = hiltViewModel(backStackEntry)
        LibraryScreen(navController = navController, viewModel = viewModel)
    }
    composable<AppRoute.LibraryContent> { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(AppRoute.Library)
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
                Text("No Media Selected")
            }
        }
    }
}
/*fun NavGraphBuilder.libraryGraph(navController: NavHostController) {

    // -------- Library Screen --------
    composable<AppRoute.Library> { backStackEntry ->
        val viewModel: MediaViewModel = hiltViewModel(backStackEntry)
        LibraryScreen(
            navController = navController,
            viewModel = viewModel
        )
    }

    // -------- Library Content Screen --------
    composable<AppRoute.LibraryContent> { backStackEntry ->

        // parent entry علشان ال ViewModel ما يتعملوش recreate
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(AppRoute.Library)
        }

        val viewModel: MediaViewModel = hiltViewModel(parentEntry)

        val selectedItem by viewModel.selectedRequest.collectAsState()

        if (selectedItem != null) {
            MediaContentScreen(
                navController = navController,
                item = selectedItem!!
            )
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No Media Selected")
            }
        }
    }
}
*/