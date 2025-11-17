package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.amjadcomposeapp.presentation.viewModel.MediaViewModel

@Composable
fun LibraryScreen(
    navController: NavController, viewModel: MediaViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    } else if (state.errorMessage != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Error: ${state.errorMessage}")
        }
        return
    } else {
        MediaList(
            navController = navController,
            state = state,
            viewModel = viewModel
        )
    }
}
