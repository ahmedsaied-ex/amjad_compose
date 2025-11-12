package com.example.amjadcomposeapp.presentation.components.uploadscreen.uploadScreenComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun NotesTextField() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= 500) text = it
            },
            modifier = Modifier
                .fillMaxWidth()

                .height(240.dp),
            textStyle = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                textDirection = TextDirection.ContentOrRtl // Arabic support
            ),
            placeholder = {
                Text(
                    text = "...أكتب ملاحظاتك هنا",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            },
            maxLines = Int.MAX_VALUE,
            shape = RoundedCornerShape(12.dp),

            )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Text(
                "اختيارى", style = TextStyle(
                    fontSize = 12.sp,
                    color = colorResource(R.color.date_color),
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Light,

                    )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${text.length}/500",
                fontSize = 14.sp,
                color = if (text.length >= 500) Color.Red else Color.Gray,
            )

        }
    }
}

