package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable

fun HrCard(navController : NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
            .height(122.dp)
            .clickable{
                navController.navigate(AppRoute.Library::class.qualifiedName!!)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        border = BorderStroke(
            width = 1.dp, brush = SolidColor(colorResource(id = R.color.border_color))
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
    ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.not_allowed_phone_illu),
                    contentDescription = "Sample image",
                )
                Spacer(modifier = Modifier.width(14.dp))
                Text(
                    "تم إرسال طلب إضافة هذا الجوال إلى إدارة الموارد البشرية. سيتم مراجعة الطلب، وسيصبح بإمكانك تسجيل الحضور عبر هذا الجوال عند الموافقة",

                    style = TextStyle(
                        fontFamily = Alexandria,
                        color = colorResource(R.color.main_color_yankies),
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                )



        }
    }
}
