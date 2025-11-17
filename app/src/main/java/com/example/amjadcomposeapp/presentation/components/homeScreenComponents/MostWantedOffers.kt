package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.MainColorYankies


@Composable
@Preview
fun MostWantedText() {
    Row (modifier = Modifier.padding(top =42.dp, start = 16.dp )){
        Image(
            painter = painterResource(id = R.drawable.ic_trending),
            contentDescription = "fire emoji",
            modifier = Modifier
                .height(22.dp)
                .width(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("أكثر شي مطلوب الفترة هذي", style = TextStyle(
            fontFamily = Alexandria,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = MainColorYankies
        )
        )

    }
}

