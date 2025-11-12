package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.MostUsedOfferModel
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun MostUsedOffersList(offers: List<MostUsedOfferModel>){
    LazyRow(modifier = Modifier.fillMaxWidth().padding(top = 22.dp)) {
        items(offers){offer->
            MostUsedOffersItem(offer)
        }
    }
}

@Composable
fun MostUsedOffersItem(offer:MostUsedOfferModel) {
    Card(
        modifier = Modifier
            .padding(end = 2.dp, bottom = 20.dp, start = 10.dp)
            .height(212.dp)
            .width(200.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Box {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(offer.mainBannerImg),
                    contentDescription = "Offer Image",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        offer.title, style = TextStyle(
                            color = colorResource(R.color.main_color_yankies),
                            fontSize = 14.sp,
                            fontFamily = Alexandria
                        ), modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)) {
                        Image(
                            painter = painterResource(R.drawable.ic_grocery),
                            contentDescription = "Offer Image",
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("أونلاين", style = TextStyle(
                            color = colorResource(R.color.shaded_assessment),
                            fontSize = 12.sp,
                        ))

                    }
                    Spacer(modifier = Modifier.heightIn(14.dp))
                }


            }
            Row(modifier = Modifier.align(Alignment.CenterStart).padding(start = 12.dp), verticalAlignment = Alignment.Bottom
            )
            {
                Card(Modifier.size(50.dp), shape = RoundedCornerShape(30.dp), elevation = CardDefaults.cardElevation(2.dp)) {
                    Image(painter = painterResource(offer.logoImg), contentDescription = "Offer Image",)
                }
                Text(offer.name,style = TextStyle(
                    color = colorResource(R.color.date_color),
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Medium

                ),
                    modifier = Modifier.padding(start = 5.dp, bottom = 7.dp)
                )
            }
        }
    }
}

