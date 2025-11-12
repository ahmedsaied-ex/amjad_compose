package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amjadcomposeapp.presentation.DetailsName
import com.example.amjadcomposeapp.presentation.components.homeScreenComponents.CompanyCard

@Composable
@Preview(
    showBackground = true, locale = "ar"
)
fun TopGroupDetails() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        ProfilePhoto()
        Spacer(modifier = Modifier.height(20.dp))
        DetailsName()
        Spacer(modifier = Modifier.height(20.dp))
        CompanyCard()
    }
}
