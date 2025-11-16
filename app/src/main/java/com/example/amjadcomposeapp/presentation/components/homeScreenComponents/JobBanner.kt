package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies


@Composable
@Preview(showBackground = true)
fun JobsPanner() {
    Card(modifier = Modifier
        .padding(top = 30.dp, start = 16.dp, end = 16.dp , bottom = 120.dp)
        .height(114.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
        containerColor = Color.White,
    )
        , elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize().padding(16.dp)){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "وظائف متاحة",
                        style = TextStyle(
                            color = MainColorYankies,
                            fontFamily = Alexandria,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        ),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        "2 جديد", style = TextStyle(
                            color = Color.White,
                            fontFamily = Alexandria,
                            fontSize = 8.sp
                        ), modifier = Modifier
                            .background(
                                color = Color.Red, // background color
                                shape = RoundedCornerShape(20.dp) // border radius
                            )
                            .padding(horizontal = 6.dp, vertical = 3.dp)
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    stringResource(R.string.job_description), style = TextStyle(
                        color = DateColor,
                        fontFamily = Alexandria,
                        fontSize = 12.sp
                    )
                )
            }
            Image(painter = painterResource(R.drawable.illu_discover_your_personality), contentDescription = "job card", modifier = Modifier.weight(0.3f))
        }
    }
}
