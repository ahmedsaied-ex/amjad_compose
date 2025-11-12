package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
          ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyLibraryHeader(
            navController = navController,
            selectedFilter = state.selectedFilter,
            onFilterChange = { viewModel.onFilterSelected(it) },
        )
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            itemsIndexed(state.filteredMedia, key = { _, item -> item.id }) { index, item ->
                if (index == 0) {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                LibraryRequestRow(item = item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }

}
