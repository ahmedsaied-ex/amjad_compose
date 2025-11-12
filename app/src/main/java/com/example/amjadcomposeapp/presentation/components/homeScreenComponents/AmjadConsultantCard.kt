package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.amjadcomposeapp.R

@Composable
fun AmjadConsultantCard(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.amjad_consultant_card_big),
        contentDescription = "hr request",
        modifier = Modifier
            .padding(top = 30.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .clickable{
                onClick()
            }
    )
}
