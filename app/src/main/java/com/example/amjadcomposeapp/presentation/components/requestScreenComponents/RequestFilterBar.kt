package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.viewModel.FilterOption
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CompanyColor
import com.example.amjadcomposeapp.ui.theme.FilterBackground
import com.example.amjadcomposeapp.ui.theme.MainColorYankies


@Composable
fun RequestFilterBar(
    selected: FilterOption,
    onSelectedChange: (FilterOption) -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(FilterBackground)
            .padding(horizontal = 4.dp, vertical = 4.dp),
    ) {

        RequestFilterChipItem(
            option = FilterOption.PENDING,
            isSelected = selected == FilterOption.PENDING,
            text = stringResource(R.string.waiting_request)
        ) { onSelectedChange(it) }

        RequestFilterChipItem(
            option = FilterOption.ACCEPTED,
            isSelected = selected == FilterOption.ACCEPTED,
            text =  stringResource(R.string.accepted)
        ) { onSelectedChange(it) }

        RequestFilterChipItem(
            option = FilterOption.REJECTED,
            isSelected = selected == FilterOption.REJECTED,
            text =  stringResource(R.string.rejected_request)
        ) { onSelectedChange(it) }

    }
}


@Composable
private fun RequestFilterChipItem(
    option: FilterOption, isSelected: Boolean, text: String, onClick: (FilterOption) -> Unit
) {
    val bgColor = if (isSelected) Color.White else Color.Transparent
    val textColor =
        if (isSelected) CompanyColor else MainColorYankies

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .clickable { onClick(option) }
            .padding(horizontal = 5.dp, vertical = 4.dp)) {
        Text(
            text = text, style = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                fontFamily = Alexandria
            )
        )
    }
}
