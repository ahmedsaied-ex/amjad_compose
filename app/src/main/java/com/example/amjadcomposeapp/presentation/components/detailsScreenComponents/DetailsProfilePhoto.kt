package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.amjadcomposeapp.R


@Composable
fun ProfilePhoto() {
    Box {
        Box(
            modifier = Modifier
                .height(115.dp)
                .width(100.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.jarir),
                contentDescription = "profile photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
            Card(
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.camera_fill),
                        contentDescription = "edit",
                    )
                }

            }

        }
    }
}
