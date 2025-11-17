package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.example.amjadcomposeapp.ui.theme.ReasonCardBackground
import com.example.amjadcomposeapp.ui.theme.ReasonCardBorder


@Composable
@Preview(locale = "ar", showBackground = true)
fun ReasonCard() {
    Card(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = ReasonCardBackground
        ),
        border = BorderStroke(
            width = 1.dp, brush = SolidColor(ReasonCardBorder)
        ),
    ) {
        TextHrRequestBody(
            title = stringResource(R.string.hr_reason_title),
            body = stringResource(R.string.hr_reason_body)
        )
    }
}


@Composable
fun TextHrRequestBody(title: String, body: String) {
    Column(
        Modifier
            .padding(vertical = 20.dp, horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            title, style = TextStyle(
                fontFamily = Alexandria, fontSize = 11.sp, color = DateColor
            )
        )
        Text(
            body, style = TextStyle(
                fontFamily = Alexandria, fontSize = 16.sp, color = MainColorYankies
            )
        )
    }
}