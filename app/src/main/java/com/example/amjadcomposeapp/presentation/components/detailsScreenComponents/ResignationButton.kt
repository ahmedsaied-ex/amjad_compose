package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.ResignationButtonColor

@Composable
fun ResignationButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = ResignationButtonColor,
            contentColor = Color.White
        )
    ) {
        Text(
            "تقديم طلب استقالة", style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 18.sp,
                color = Color.White
            )
        )
    }
}

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