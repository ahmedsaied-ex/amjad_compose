package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun RequestTimeCard(time: String) {
    Card(
        modifier = Modifier
            .padding(bottom = 6.dp)
            .fillMaxWidth()
            .height(60.dp),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(
            width = 1.dp, brush = SolidColor(colorResource(id = R.color.survey_number_background))
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            RequestTimeColumn(
                title = stringResource(R.string.time_sent), time =time
            )
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(27.dp)
                    .background(Color.Gray)
            )
            RequestTimeColumn(
                title = stringResource(R.string.time_response), time = time
            )
        }
    }

}

@Composable
fun RequestTimeColumn(title: String, time: String) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RequestTimeTitle(title)
        RequestTimeTitleDetails(time)
    }
}

@Composable
fun RequestTimeTitle(title: String) {
    Text(
        title, style = TextStyle(
            fontSize = 10.sp,
            fontFamily = Alexandria,
            color = colorResource(R.color.date_color),
            fontWeight = FontWeight.Light

        )
    )
}

@Composable
fun RequestTimeTitleDetails(time: String) {
    Text(
        time, style = TextStyle(
            fontSize = 11.sp,
            fontFamily = Alexandria,
            color = colorResource(R.color.main_color_yankies),
        )
    )
}

