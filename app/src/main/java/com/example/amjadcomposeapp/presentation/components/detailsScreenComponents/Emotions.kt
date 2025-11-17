package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.EmojisModel
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.EmojisNameColor
import com.example.amjadcomposeapp.ui.theme.EmotionHistoryText
import com.example.amjadcomposeapp.ui.theme.EmotionsBorderColor
import com.example.amjadcomposeapp.ui.theme.EmotionsCardBackground
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import kotlin.collections.forEach


@Composable
fun EmotionsBanner(emojis: List<EmojisModel>) {

    Card(
        modifier = Modifier
            .padding(vertical = 20.dp)
            .fillMaxWidth()
            .height(166.dp),
        border = BorderStroke(
            width = 1.dp, brush = SolidColor(EmotionsBorderColor)
        ),
        colors = CardDefaults.cardColors(
            containerColor = EmotionsCardBackground
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 14.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(R.string.today_emotions), style = TextStyle(
                        fontFamily = Alexandria,
                        fontSize = 14.sp,
                        color = MainColorYankies
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                EmojisRow(emojis = emojis)
            }
            BackgroundEmojis()


        }
        BottomEmotionsCard()
    }
}

@Composable
@Preview(locale = "ar")
fun BottomEmotionsCard() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(EmotionsBorderColor),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(R.drawable.ic_history), contentDescription = "history")
        Text(
            stringResource(R.string.emotions_history), style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 14.sp,
                color = EmotionHistoryText
            ), modifier = Modifier.padding(horizontal = 6.dp)
        )
        Image(painter = painterResource(R.drawable.ic_angle), contentDescription = "share")

    }
}

@Composable
fun BackgroundEmojis() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.emoji_right_bottom_corner_illu),
            contentDescription = "bottom right ",
            modifier = Modifier.align(Alignment.BottomStart),

            )
        Image(
            painter = painterResource(R.drawable.emoji_left_top_corner_illu),
            contentDescription = "top left ",
            modifier = Modifier.align(Alignment.TopEnd),

            )

    }
}


@Composable
fun EmojiCard(emoji: EmojisModel) {
    Column(
        modifier = Modifier
            .height(50.dp)
            .width(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(emoji.emoji), contentDescription = "emoji"
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = emoji.name, style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 8.sp,
                fontWeight = FontWeight.Medium,
                color = EmojisNameColor
            )
        )


    }
}

@Composable
fun EmojisRow(emojis: List<EmojisModel>) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly // 👈 distributes evenly
    ) {
        emojis.forEach { item ->
            EmojiCard(emoji = item)
        }
    }
}