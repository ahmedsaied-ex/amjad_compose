package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData

@Composable
@Preview(locale = "ar", showBackground = true)
fun FamilyMembers() {
    CustomDetailsStack(
        title = stringResource(R.string.family_members), items = listOf(
            {
                DetailsRowCard(
                    DetailsRowData(
                        title = stringResource(R.string.family_members),
                        image = R.drawable.ic_family_members_profile
                    ), onItemClick = {})

            })
    )
}
