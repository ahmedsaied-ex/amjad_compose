package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestItem
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

@Composable
fun RequestDetailsScreen(navController: NavController,item: RequestItem?) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TopRequestDetails(
                navController = navController,
                name = item?.name?:"",
                status = item?.status?: RequestStatus.PENDING,
                time = item?.description?:"",
            )
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            ReasonCard()
        }
        item {
            RequestDetailsCard(
                firstItem = {
                    TextHrRequestBody(
                        title = stringResource(R.string.what_requiured),
                        body = stringResource(R.string.what_required_body)
                    )
                }, secondItem = {
                    TextHrRequestBody(
                        title = stringResource(R.string.notes),
                        body = stringResource(R.string.notes_body)
                    )
                }, cardTitle = stringResource(R.string.request_details)
            )
        }
        item {
            RequestDetailsCard(
                firstItem = {
                    ProfileRow(
                        img = R.drawable.emoji_enthusiastic,
                        title = "مدير القسم",
                        name = "منصور الغامدي"
                    )

                },
                secondItem = {
                    TextHrRequestBody(
                        title = "تاريخ الموافقة",
                        body = "1 نوفمبر 2024 10:08 ص",
                    )
                },
                cardTitle = "موافقة مدير قسم الموظف"
            )
        }
    }

}


@Composable
fun RequestDetailsCard(
    firstItem: @Composable () -> Unit, secondItem: @Composable () -> Unit, cardTitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 16.dp),

        ) {
        Text(
            cardTitle, style = TextStyle(
                color = MainColorYankies,
                fontSize = 18.sp,
                fontFamily = Alexandria,
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column {
                firstItem()
                secondItem()
            }

        }

    }

}


