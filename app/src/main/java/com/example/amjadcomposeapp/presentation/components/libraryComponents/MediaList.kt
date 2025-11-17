package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.presentation.viewModel.MediaUiState
import com.example.amjadcomposeapp.presentation.viewModel.MediaViewModel


@Composable
fun MediaList( navController:NavController, state: MediaUiState, viewModel:MediaViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize(),
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
                .fillMaxSize(),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            items(state.filteredMedia) { item ->
                LibraryRequestRow(
                    item = item,
                    navController = navController,
                    viewModel = viewModel
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}