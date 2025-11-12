package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.OffersCategoryModel
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun OffersCategoryList(offersCategory: List<OffersCategoryModel>) {
    LazyRow(modifier = Modifier.padding( top =18.dp )) {
        items(offersCategory) { offer ->
            OffersCategoryItem(offer)
        }
    }
}
@Composable
fun OffersCategoryItem(offer :OffersCategoryModel ) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 2.dp)
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
                .background(color = colorResource(R.color.offers_category_item))
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
                color = colorResource(R.color.main_color_yankies)
            )
        )
    }

}