package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData


@Composable
fun PersonalDataDetails(){
    CustomDetailsStack(
        items = listOf(
            {
                DetailsRowCard(
                    DetailsRowData(
                        title = stringResource(R.string.essintial_data),
                        image = R.drawable.ic_settings_profile_1
                    ),
                    onItemClick = {}
                )
            },
            {
                DetailsRowCard(
                    DetailsRowData(
                        title = stringResource(R.string.favorite_offer_categories),
                        image = R.drawable.ic_offer_preferences_profile
                    ),
                    onItemClick = {}
                )
            }
        ),
        title = stringResource(R.string.my_personal_profile)
    )
}

