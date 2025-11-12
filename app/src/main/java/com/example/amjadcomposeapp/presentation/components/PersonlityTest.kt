package com.example.amjadcomposeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.components.homeScreenComponents.PersonalityDialog
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable
@Preview(showBackground = true)
fun PersonalityCard() {
    var showDialog by remember { mutableStateOf(false) }

    Box() {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(164.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        stringResource(R.string.discover_your_true_self), style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = Alexandria,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(R.color.main_color_yankies)
                        )
                    )

                    Text(
                        stringResource(R.string.personality_body), style = TextStyle(
                            color = colorResource(R.color.date_color),
                            fontFamily = Alexandria,
                            fontSize = 12.sp
                        )
                    )

                    Button(
                        onClick = { showDialog = true },
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.company_color),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            stringResource(R.string.discover_your_personality_now),
                            style = TextStyle(fontFamily = Alexandria, fontSize = 14.sp)
                        )
                    }
                }

                Spacer(Modifier.width(8.dp))

                Image(
                    painter = painterResource(R.drawable.illu_discover_your_personality),
                    contentDescription = "Personality photo",
                    modifier = Modifier.weight(1f)
                )
            }
        }


        if (showDialog) {
            PersonalityDialog(
                onDismiss = { showDialog = false }, onConfirm = {
                    showDialog = false
                }
            )

        }
    }
}

