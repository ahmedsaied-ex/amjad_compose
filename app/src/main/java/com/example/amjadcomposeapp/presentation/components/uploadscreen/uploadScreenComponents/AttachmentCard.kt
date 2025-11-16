package com.example.amjadcomposeapp.presentation.components.uploadscreen.uploadScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun AttachmentCard(fileName: String, fileSize: String, onRemove: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = 2.dp, color = colorResource(R.color.dashed_color)
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.reason_card_background)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.ic_pdf),
                contentDescription = "Pdf image", modifier = Modifier
                    .height(30.dp)
                    .width(23.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(11f)) {
                Text(
                    fileName, style = TextStyle(
                        color = colorResource(R.color.main_color_yankies),
                        fontWeight = FontWeight.Medium,
                        fontFamily = Alexandria,
                        fontSize = 14.sp

                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    fileSize,
                    style = TextStyle(
                        color = colorResource(R.color.pdf_size_color),
                        fontFamily = Alexandria,
                        fontSize = 14.sp
                    ),
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                Image(
                    painterResource(R.drawable.ic_delete),
                    contentDescription = "delete attachment icon",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterEnd)
                        .clickable {
                            onRemove()
                        }

                )
            }


        }

    }
}
