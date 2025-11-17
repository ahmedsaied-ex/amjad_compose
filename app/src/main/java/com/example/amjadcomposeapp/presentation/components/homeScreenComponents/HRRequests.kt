package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.domain.models.HrRequestModel
import com.example.amjadcomposeapp.helpers.UiState
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CardStroke
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.example.amjadcomposeapp.ui.theme.White
import com.google.android.material.loadingindicator.LoadingIndicator


@Composable
fun HRRequests(hrList: UiState<List<HrRequestModel>>, navController: NavController,context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp)
            .height(122.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        border = BorderStroke(
            width = 1.dp, brush = SolidColor(CardStroke)
        ),
    ) {
        when (hrList) {
            is UiState.Success -> {
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    items(hrList.data) { request ->
                        HrRequestItem(request = request, navController =  navController)
                    }
                }
            }
            is UiState.Loading -> { Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                LoadingIndicator(context)
            }
            }
            is UiState.Error -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(text = hrList.message, color = Color.Red)
                }
            }

        }

    }

}

@Composable
fun HrRequestItem(request: HrRequestModel, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .width(80.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center, // ✅ centers the image inside
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp)) // ✅ rounded corners for the image box
                .background(color = request.color)
                .clickable {
                    navController.navigate(AppRoute.Requests::class.qualifiedName!!)
                }
        ) {
            Image(
                painter = painterResource(request.imgUrl),
                contentDescription = "hr request",
                modifier = Modifier
                    .size(20.dp)

                // ✅ ensures image also has rounded corners

            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = request.name,
            style = TextStyle(
                fontFamily = Alexandria,
                color = MainColorYankies,
                fontSize = 11.sp
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
