package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DetailsRowProfileImageBackground
import com.example.amjadcomposeapp.ui.theme.MainColorYankies


@Composable
fun CustomDetailsStack(items: List<@Composable () -> Unit>, title: String) {
    Column {
        Spacer(modifier = Modifier.height(30.dp))
        TitleCardText(title = title)
        CustomMultipleDetailsStackCard(items = items)
    }
}


@Composable
fun CustomMultipleDetailsStackCard(items: List<@Composable () -> Unit>) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), shape = RoundedCornerShape(12.dp), // ✅ optional rounded card
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {

            items.forEach { item ->
                item()
            }
        }
    }
}

@Composable
fun CustomSingleDetailsStackCard(img: Int, title: String){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), shape = RoundedCornerShape(12.dp), // ✅ optional rounded card
        modifier = Modifier.fillMaxWidth()
    ) {
        DetailsRowCard(
            DetailsRowData(
                title = title,
                image =img
            ), onItemClick = {}
        )
    }
}

@Composable
fun LogoutCard(item: DetailsRowData, onItemClick: () -> Unit){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), shape = RoundedCornerShape(12.dp), // ✅ optional rounded card
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .height(64.dp)
                .clickable { onItemClick() }, verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 4.dp, end = 12.dp)
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(DetailsRowProfileImageBackground)
            ) {
                Image(
                    painter = painterResource(item.image),
                    contentDescription = "profile",
                    modifier = Modifier.align(Alignment.Center)

                )
            }
            Text(
                item.title, style = TextStyle(
                    fontFamily = Alexandria,
                    fontSize = 16.sp,
                    color = MainColorYankies
                )
            )

        }
    }
}



