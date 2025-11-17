package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.AssessmentCardModel
import com.example.amjadcomposeapp.helpers.UiState
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.AssessmentColorProvider
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.example.amjadcomposeapp.ui.theme.ShadedAssessment
import com.google.android.material.loadingindicator.LoadingIndicator


@Composable
fun AssessmentList(assessments: UiState<List<AssessmentCardModel>>,context: Context) {
   when(assessments){
       is UiState.Loading -> {
           Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
               LoadingIndicator(context)
           }
       }
       is UiState.Success -> {
           LazyRow(modifier = Modifier.padding(top = 40.dp), contentPadding = PaddingValues(horizontal = 11.dp)) {
               itemsIndexed(assessments.data) { index, assessment ->
                   val (initialColor, finalColor) = AssessmentColorProvider.getGradientColorsByIndex(
                       index
                   )
                   AssessmentCard(
                       assessment = assessment,
                       initialColor = initialColor,
                       finalColor = finalColor
                   )
               }
           }
       }
       is UiState.Error -> {
           Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
               Text(text = assessments.message,)
           }
       }
   }

}

@Composable
fun AssessmentCard(assessment: AssessmentCardModel, initialColor: Color, finalColor: Color) {
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .size(168.dp)
        ,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {


        Column(modifier = Modifier.fillMaxSize()) {
            AssessmentCardImage(
                initialColor = initialColor,
                finalColor = finalColor,
                img = assessment.img,
                title = assessment.title

            )
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                QuestionsRaw(
                    assessmentName = "اسئله",
                    count = assessment.questions,
                    image = R.drawable.help
                )
                QuestionsRaw(
                    assessmentName = "دقائق",
                    count = assessment.minutes,
                    image = R.drawable.schedule
                )
            }

        }
    }

}

@Composable
fun QuestionsRaw(assessmentName: String, count: Int, image: Int) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(image),
            contentDescription = "Assessment help",
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            count.toString(), style = TextStyle(
                color = MainColorYankies,
                fontFamily = Alexandria,
                fontSize = 14.sp
            )
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            assessmentName, style = TextStyle(
                fontSize = 11.sp,
                color = ShadedAssessment,
                fontFamily = Alexandria,
            )
        )
    }
}

@Composable
fun AssessmentCardImage(initialColor: Color, finalColor: Color, img: Int, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 122.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        initialColor, // Orange
                       finalColor, // Orange
                        // Amber
                    )
                )
            )
            .padding(all = 12.dp)
    ) {
        Image(
            modifier = Modifier.align(Alignment.TopEnd),
            alignment = Alignment.TopEnd,
            painter = painterResource(id = img),
            contentDescription = "Assessment image"
        )
        Column(modifier = Modifier.align(Alignment.BottomStart)) {
            Text(
                stringResource(R.string.measurement), style = TextStyle(
                    color = MainColorYankies,
                    fontFamily = Alexandria,
                    fontSize = 13.sp
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = title, style = TextStyle(
                    color = MainColorYankies,
                    fontFamily = Alexandria,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}