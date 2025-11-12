package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData

@Composable
@Preview(locale = "ar", showBackground = true)
fun Favourites() {
    CustomDetailsStack(
        title = stringResource(id = R.string.favourites), items = listOf(
            {
                DetailsRowCard(
                    DetailsRowData(
                        title = stringResource(R.string.favourite_offers),
                        image = R.drawable.ic_offers_profile
                    ), onItemClick = {})
                DetailsRowCard(
                    DetailsRowData(
                        title = stringResource(R.string.favourite_shops),
                        image = R.drawable.ic_vendors_profile
                    ), onItemClick = {})
            })
    )
}
