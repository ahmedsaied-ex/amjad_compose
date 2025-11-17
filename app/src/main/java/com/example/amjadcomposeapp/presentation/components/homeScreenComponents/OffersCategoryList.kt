package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import com.example.amjadcomposeapp.helpers.UiState
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.example.amjadcomposeapp.ui.theme.OffersCategoryItem
import com.google.android.material.loadingindicator.LoadingIndicator


@Composable
fun OffersCategoryList(offersCategory: UiState<List<OffersCategoryModel>>,context: Context) {
    when(offersCategory){
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxWidth().height(140.dp)){
                LoadingIndicator(context)
            }
        }
        is UiState.Success -> {
            LazyRow(modifier = Modifier.padding( top =18.dp ), contentPadding = PaddingValues(start = 6.dp, end = 16.dp)) {
                items(offersCategory.data) { offer ->
                    OffersCategoryItem(offer)
                }
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
fun OffersCategoryItem(offer :OffersCategoryModel ) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp)
            .height(110.dp)
            .width(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(id = offer.img),
            contentDescription = "Offer item",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(color = OffersCategoryItem)
                .padding(24.dp)
                .size(32.dp)
                .align(Alignment.CenterHorizontally) // rounded corners
        )
        Spacer(Modifier.weight(1f))
        Text(
            offer.title, style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = MainColorYankies
            )
        )
    }

}