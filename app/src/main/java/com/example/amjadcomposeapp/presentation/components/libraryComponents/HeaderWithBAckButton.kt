package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable
fun HeaderWithBackButton(
    title: String,
    onBackClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Back button
        if (onBackClick != null) {
            Image(
                painter = painterResource(R.drawable.ic_back__1_),
                contentDescription = "back button",
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { onBackClick() }
            )
        } else {
            Spacer(modifier = Modifier.width(48.dp)) // Keeps title centered if no back button
        }

        // Title
        Text(
            text = title,
            style = TextStyle(
                color = colorResource(R.color.main_color_yankies),
                fontSize = 16.sp,
                fontFamily = Alexandria
            )
        )

        Spacer(modifier = Modifier.width(48.dp)) // Balance the row
    }
}