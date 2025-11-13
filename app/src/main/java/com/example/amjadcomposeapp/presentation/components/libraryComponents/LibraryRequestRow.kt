package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.presentation.viewModel.MediaViewModel
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun LibraryRequestRow(item: MediaRequest, navController: NavController, viewModel: MediaViewModel = viewModel()) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable{
                viewModel.selectRequest(item)
                navController.navigate(AppRoute.LibraryContent::class.qualifiedName!!)
            }, // optional spacing between rows
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Media Icon
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(R.color.filter_background)),
                contentAlignment = Alignment.Center
            ) {
                when (item.type) {
                    MediaType.ARTICLES -> Image(
                        painter = painterResource(item.thumbnailUrl?: R.drawable.ic_article),
                        contentDescription = "Article Icon"
                    )
                    MediaType.AUDIO -> Image(
                        painter = painterResource(item.thumbnailUrl?:R.drawable.ic_audio),
                        contentDescription = "Audio Icon"
                    )
                    MediaType.VIDEO -> Image(
                        painter = painterResource(item.thumbnailUrl?:R.drawable.ic_video),
                        contentDescription = "Video Icon"
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Text content
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontFamily = Alexandria,
                        color = colorResource(R.color.main_color_yankies),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = item.description,
                    style = TextStyle(
                        fontFamily = Alexandria,
                        color = colorResource(R.color.date_color),
                        fontSize = 11.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = "متوفر حتى:",
                        style = TextStyle(
                            fontFamily = Alexandria,
                            color = colorResource(R.color.date_color),
                            fontSize = 11.sp
                        )
                    )
                    Text(
                        text = " 5 ابريل 2025 ",
                        style = TextStyle(
                            fontFamily = Alexandria,
                            color = colorResource(R.color.main_color_yankies),
                            fontSize = 11.sp
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))

            when (item.type) {
                MediaType.ARTICLES -> return@Card
                else -> {
                    Box(
                        modifier = Modifier.size(28.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_play),
                            contentDescription = "Play Icon"
                        )
                    }
                }
            }
        }
    }
}
