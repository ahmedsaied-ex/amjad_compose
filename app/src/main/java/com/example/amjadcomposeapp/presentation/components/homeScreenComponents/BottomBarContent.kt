package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.BottomBarEmojis
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CompanyColor
import com.example.amjadcomposeapp.ui.theme.White


@Composable
fun BottomBarContent(emojisList: List<BottomBarEmojis>, onClose: () -> Unit) {
    Box( modifier = Modifier
        .padding(horizontal = 70.dp, vertical = 16.dp)
        .clip(
            shape = RoundedCornerShape(30.dp)
        )
        .background(CompanyColor)
        .height(60.dp)
        ,
        contentAlignment = Alignment.Center) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ImageSlideAnimation(
                emojisList = emojisList,
            )
            Text(
                stringResource(R.string.what_is_your_felling), style = TextStyle(
                    color = White,
                    fontSize = 14.sp,
                    fontFamily = Alexandria,
                )
            )
            Image(
                painter = painterResource(R.drawable.ic_close_bottom_banner_close),
                contentDescription = "close icon",
                modifier = Modifier.clickable {
                    onClose()
                },
            )
        }
    }
}

