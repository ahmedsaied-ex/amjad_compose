package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R

@Composable
fun DetailAppBar(navController: NavController){
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(R.drawable.ic_back), contentDescription = "back",modifier = Modifier.clickable{
            navController.popBackStack()
        })
    }

}

