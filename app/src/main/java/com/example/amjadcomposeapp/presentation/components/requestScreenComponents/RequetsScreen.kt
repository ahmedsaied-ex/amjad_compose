package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.presentation.viewModel.FilterOption
import com.example.amjadcomposeapp.presentation.viewModel.RequestsViewModel
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

@Composable
fun RequestsScreen(
    navController: NavController,
    viewModel: RequestsViewModel = hiltViewModel()
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
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RequestsHeader(
            navController = navController,
            selectedFilter = state.selectedFilter,
            onFilterChange = { viewModel.onFilterSelected(it) }
        )

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            itemsIndexed(state.filteredItems, key = { _, item -> item.id }) { index, item ->
                if (index == 0) {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                RequestRow(item = item, navController = navController,viewModel=viewModel)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@Composable
fun RequestsHeader(
    navController: NavController,
    selectedFilter: FilterOption,
    onFilterChange: (FilterOption) -> Unit,
    onBackClick: (() -> Unit)? = null,


    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_back__1_),
                contentDescription = "back button",
                modifier = Modifier
                    .padding(4.dp)
                    .then(
                        if (onBackClick != null)
                            Modifier
                                .background(Color.Transparent)
                                .padding(4.dp)
                        else Modifier
                    )
                    .clickable {
                        navController.popBackStack()
                    }
            )

            Text(
                text = stringResource(R.string.requests_that_sended_to_you),
                style = TextStyle(
                    color = MainColorYankies,
                    fontSize = 16.sp,
                    fontFamily = Alexandria
                )
            )

            Image(
                painter = painterResource(R.drawable.ic_filter),
                contentDescription = "filter button",
                modifier = Modifier
                    .padding(4.dp)

            )
        }

        // فلتر الطلبات
        RequestFilterBar(
            selected = selectedFilter,
            onSelectedChange = onFilterChange
        )
        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
fun StatusPill(status: RequestStatus) {

    val ui = status.toMainBannerUI()

    Card(
        colors = CardDefaults.cardColors(ui.backgroundColor),
        border = BorderStroke(1.dp, SolidColor(ui.borderColor)),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(ui.text),
                color = ui.textColor,
                fontFamily = Alexandria,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}
