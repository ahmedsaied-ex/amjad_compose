package com.example.amjadcomposeapp.presentation.components.libraryComponents.mediaContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.CostumeAppBar
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies


@Composable
fun Article(url: String, thumbnailUrl: Int?, navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CostumeAppBar(
            navController = navController,
            icon = R.drawable.ic_back__1_,
            text = R.string.content_description
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(thumbnailUrl ?: R.drawable.banner_img),
                    contentDescription = "Article Image",
                    modifier = Modifier.clip(
                        shape = RoundedCornerShape(7.dp)
                    )
                )
                Spacer(Modifier.height(20.dp))
            }
            item {
                HeaderText("دليل شامل لفهم أساسيات التأمين الشخصي والعائلي")
                Spacer(Modifier.height(20.dp))
            }
            item {
               ContentText(url)
                Spacer(Modifier.height(20.dp))
            }
            item {
                HeaderText("دليل شامل لفهم أساسيات التأمين الشخصي والعائلي")
                Spacer(Modifier.height(20.dp))
            }
            item {
                ContentText(url)
                Spacer(Modifier.height(20.dp))
            }

            item {
                HeaderText("دليل شامل لفهم أساسيات التأمين الشخصي والعائلي")
                Spacer(Modifier.height(20.dp))
            }
            item {
                ContentText(url)
                Spacer(Modifier.height(20.dp))
            }

            item {
                HeaderText("دليل شامل لفهم أساسيات التأمين الشخصي والعائلي")
                Spacer(Modifier.height(20.dp))
            }
            item {
                ContentText(url)
                Spacer(Modifier.height(20.dp))
            }

            item {
                HeaderText("دليل شامل لفهم أساسيات التأمين الشخصي والعائلي")
                Spacer(Modifier.height(20.dp))
            }
            item {
                ContentText(url)
                Spacer(Modifier.height(20.dp))
            }


        }
    }

}

@Composable
fun HeaderText(text: String){
    Text(
        text,
        style = TextStyle(
            fontSize = 18.sp,
            color = MainColorYankies,
            fontWeight = FontWeight.SemiBold,
            fontFamily = Alexandria
        )
    )
}

@Composable
fun ContentText(text: String){
    Text(
        text,
        style = TextStyle(
            fontSize = 11.sp,
            fontFamily = Alexandria,
            color = DateColor
        ),
        )

}

