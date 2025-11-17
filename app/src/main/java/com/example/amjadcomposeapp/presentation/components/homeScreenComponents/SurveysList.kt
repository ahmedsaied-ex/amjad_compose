package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.domain.models.SurveysTabsModel
import com.example.amjadcomposeapp.helpers.UiState
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CardStroke
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.example.amjadcomposeapp.ui.theme.SurveyNumberBackground
import com.google.android.material.loadingindicator.LoadingIndicator


@Composable
fun SurveysList(serves: UiState<List<SurveysTabsModel>>, context: Context) {
    when (serves) {
        is UiState.Error -> {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)) {
                Text(
                    "there was an error", style = TextStyle(
                        color = Color.Red.copy(alpha = .5f)
                    )
                )
            }
        }

        is UiState.Loading ->
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)) {
                LoadingIndicator(context)
            }

        is UiState.Success -> {
            Row(
                modifier = Modifier.padding(top = 40.dp, end =8.dp, start = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                serves.data.forEach {
                    SurveysTabs(it,)
                    Spacer(modifier = Modifier.width(8.dp))
                }

            }
        }
    }
}

@Composable
fun SurveysTabs(survey: SurveysTabsModel, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(
            containerColor = Color.White // background color
        ), modifier = modifier
            .border(
                width = 1.dp, color = CardStroke, // border color
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = SurveyNumberBackground)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = survey.number.toString(),
                    style = TextStyle(
                        color = DateColor,
                        fontSize = 12.sp,
                        fontFamily = Alexandria,
                    )
                )

            }
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = survey.title,
                style = TextStyle(
                    color = MainColorYankies,
                    fontSize = 14.sp,
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

