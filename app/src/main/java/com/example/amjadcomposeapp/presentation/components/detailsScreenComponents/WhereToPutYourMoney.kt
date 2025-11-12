package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable
fun WhereToPutYourMoney(){
    Text(
        modifier=Modifier.padding(top = 43.dp, start = 16.dp),
        text="وين تحب توفر فلوسك؟", style = TextStyle(
            fontFamily = Alexandria,
            fontSize = 16.sp,
            color = colorResource(R.color.main_color_yankies),
            fontWeight = FontWeight.SemiBold
        ))
}
