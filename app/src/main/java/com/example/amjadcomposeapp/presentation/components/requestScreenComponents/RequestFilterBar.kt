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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.viewModel.FilterOption
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun RequestFilterBar(
    selected: FilterOption,
    onSelectedChange: (FilterOption) -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp)) // هنا نعمل الحواف مستديرة
            .background(colorResource(R.color.filter_background))
            .padding(horizontal = 8.dp, vertical = 4.dp), // Padding داخلي للراحة
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        RequestFilterChipItem(
            option = FilterOption.PENDING,
            isSelected = selected == FilterOption.PENDING,
            text = "بانتظار موافقتك"
        ) { onSelectedChange(it) }

        RequestFilterChipItem(
            option = FilterOption.ACCEPTED,
            isSelected = selected == FilterOption.ACCEPTED,
            text = "مقبولة"
        ) { onSelectedChange(it) }

        RequestFilterChipItem(
            option = FilterOption.REJECTED,
            isSelected = selected == FilterOption.REJECTED,
            text = "مرفوضة"
        ) { onSelectedChange(it) }

    }
}


@Composable
private fun RequestFilterChipItem(
    option: FilterOption, isSelected: Boolean, text: String, onClick: (FilterOption) -> Unit
) {
    val bgColor = if (isSelected) Color.White else Color.Transparent
    val textColor =
        if (isSelected) colorResource(R.color.company_color) else colorResource(R.color.main_color_yankies)

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .clickable { onClick(option) }
            .padding(horizontal = 12.dp, vertical = 8.dp)) {
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
