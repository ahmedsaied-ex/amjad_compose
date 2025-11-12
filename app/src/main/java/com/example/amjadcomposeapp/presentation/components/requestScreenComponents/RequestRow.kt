package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestItem
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.presentation.viewModel.RequestsViewModel
import com.example.amjadcomposeapp.ui.theme.Alexandria
import java.net.URLEncoder
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun RequestRow(
    item: RequestItem,
    navController: NavController,
    viewModel: RequestsViewModel = hiltViewModel()
) {
    Card(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .clickable {
                viewModel.selectRequest(item)
                navController.navigate(AppRoute.RequestDetails::class.qualifiedName!!)
            }
        ,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            StatusPill(status = item.status)
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.jarir), // replace with your image
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = Color.Yellow,
                            shape = CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(14.dp))
                Text(
                    item.name, style = TextStyle(
                        color = colorResource(R.color.main_color_yankies),
                        fontSize = 14.sp,
                        fontFamily = Alexandria,
                        fontWeight = FontWeight.Medium
                    )
                )

            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = stringResource(R.string.sent_at), style = TextStyle(
                        fontSize = 11.sp,
                        color = colorResource(R.color.date_color),
                        fontFamily = Alexandria
                    )
                )

                Text(
                    text =item.description, style = TextStyle(
                        fontSize = 11.sp,
                        color = colorResource(R.color.main_color_yankies),
                        fontFamily = Alexandria
                    )
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))


    }

}
