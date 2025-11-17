package com.example.amjadcomposeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.amjadcomposeapp.presentation.components.libraryComponents.LibraryScreen
import com.example.amjadcomposeapp.presentation.components.uploadscreen.UploadScreen
import com.example.amjadcomposeapp.presentation.viewModel.UploadViewModel

fun NavGraphBuilder.attachmentGraph(navController: NavHostController) {
    composable<AppRoute.Attachment> {
        UploadScreenRoute(navController)
    }
}

@Composable
fun UploadScreenRoute(navController: NavController) {
    val viewModel: UploadViewModel = hiltViewModel()
    UploadScreen(viewModel = viewModel, navController = navController)
}