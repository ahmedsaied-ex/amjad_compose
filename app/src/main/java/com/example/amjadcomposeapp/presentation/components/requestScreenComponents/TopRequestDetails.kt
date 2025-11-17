package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.ui.theme.TopColumRequestsBackground


@Composable
fun TopRequestDetails(navController : NavController,name : String,status: RequestStatus,time : String,) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Column(
                modifier = Modifier
                    .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            TopColumRequestsBackground
                        )
                    )
                )
                    .padding(horizontal = 16.dp)
            ) {
                CostumeAppBar(
                    navController = navController,
                    icon = R.drawable.ic_back,
                    text = R.string.request_decription
                )
                StatusPill(
                    status = status
                )
                Spacer(modifier = Modifier.height(20.dp))
                RequestTimeCard(
                    time =time 
                )
                RequestProfileDetails(
                    name = name
                )
                Spacer(modifier = Modifier.height(17.dp))
            }
            Spacer(modifier = Modifier.height(17.dp))
        }

        HRRequestState(modifier = Modifier.align(Alignment.BottomCenter), status = status)
    }
}

