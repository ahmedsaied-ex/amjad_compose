package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

@Composable
fun WhereToPutYourMoney(){
    Row(modifier = Modifier.padding(top = 43.dp, start = 16.dp).fillMaxWidth()) {
        Image(painter = painterResource(R.drawable.ic_shopping), contentDescription = "shopping bags image")
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "وين تحب توفر فلوسك؟", style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 16.sp,
                color = MainColorYankies,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}
