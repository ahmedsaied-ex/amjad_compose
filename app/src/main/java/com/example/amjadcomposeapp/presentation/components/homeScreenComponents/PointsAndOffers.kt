package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData
import com.example.amjadcomposeapp.presentation.components.detailsScreenComponents.CustomDetailsStack
import com.example.amjadcomposeapp.presentation.components.detailsScreenComponents.DetailsRowCard

@Composable
@Preview(locale = "ar", showBackground = true)
fun PointsAndOffers() {
    CustomDetailsStack(
        title = stringResource(R.string.points_and_offers),
        items = listOf(
            {
                DetailsRowCard(
                    DetailsRowData(
                        title = stringResource(R.string.points_that_used),
                        image = R.drawable.ic_redeemed_offers_profile
                    ),
                    onItemClick = {}
                )
            }
        )
    )
}
