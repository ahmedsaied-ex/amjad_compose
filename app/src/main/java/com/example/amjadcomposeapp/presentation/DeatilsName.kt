package com.example.amjadcomposeapp.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable
fun DetailsName(){
    Text(
        stringResource(R.string.name), style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontFamily = Alexandria,
            fontSize = 22.sp,
            color = MainColorYankies
        )
    )
}