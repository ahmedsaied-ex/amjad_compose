package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun HRRequestState(modifier: Modifier,status:RequestStatus) {
    val ui = status.toSmallBannerUI()
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .border(
                width = 2.dp, // border thickness
                color = ui.borderColor, // border clor
                shape = RoundedCornerShape(16.dp) // same shape as the background
            )
            .background(
                color =ui.backgroundColor, // background color
                shape = RoundedCornerShape(16.dp) // rounded corners
            )
            .padding(horizontal = 12.dp, vertical = 6.dp) // padding inside the row
    ) {
        Image(
            painter = painterResource(ui.icon),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp) // image size
                .clip(RoundedCornerShape(12.dp)) // optional: rounded image
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(ui.text),
            style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 12.sp,
                color =  ui.textColor
            ),

            )
    }
}