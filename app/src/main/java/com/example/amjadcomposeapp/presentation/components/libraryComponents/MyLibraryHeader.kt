package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.viewModel.MediaFilter


@Composable
fun MyLibraryHeader(
    navController: NavController,
    selectedFilter: MediaFilter,
    onFilterChange: (MediaFilter) -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .padding(top = 13.dp)
    ) {

        HeaderWithBackButton(
            title = stringResource(R.string.requests_that_sended_to_you),
            onBackClick = { navController.popBackStack() },

            )
        LibraryFilterBar(
            selected = selectedFilter, onSelectedChange = onFilterChange
        )
        Spacer(modifier = Modifier.height(6.dp))
    }
}








