package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.NewsModel
import com.example.amjadcomposeapp.helpers.UiState
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.example.amjadcomposeapp.ui.theme.NewsNumberText
import com.google.android.material.loadingindicator.LoadingIndicator


@Composable
fun NewsList(news: UiState<List<NewsModel>>,context: Context) {
    when (news) {
        is UiState.Success -> {
            LazyRow(modifier = Modifier.padding(top = 10.dp), contentPadding = PaddingValues(horizontal = 11.dp)) {
                items(news.data) {news->
                    NewsCard(news = news)
                }
            }
        }
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxWidth().height(140.dp)){
                LoadingIndicator(context)
            }
        }
        is UiState.Error -> {
            Box(modifier = Modifier.fillMaxWidth().height(60.dp)){
                Text("there was an error", style = TextStyle(
                    color = Color.Red.copy(alpha =.5f )
                ))
            }
        }
    }
}

@Composable
fun NewsCard(news: NewsModel) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Card(modifier = Modifier
            .padding(horizontal = 5.dp,)
            .height(192.dp)
            .width(280.dp)
            ,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)

        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(news.img),
                    contentDescription = "offer image",
                    contentScale = ContentScale.Crop, // makes it fill and crop nicely
                    modifier = Modifier
                        .fillMaxWidth() // fill width of the card
                        .height(140.dp) // control height of the card
                )

                Row(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal =14.dp ),verticalAlignment =Alignment.CenterVertically) {
                    Text(news.title,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily =Alexandria,
                            color = MainColorYankies
                        ))
                    Spacer(Modifier.weight(1f))
                    Image(painter = painterResource(R.drawable.ic_views), contentDescription ="arrow right" )
                    Spacer(Modifier.width(4.dp))
                    Text(news.views.toString(),style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Alexandria,
                        color = NewsNumberText
                    ))
                }
            }}
    }
}
