package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.DetailsRowProfileImageBackground
import com.example.amjadcomposeapp.ui.theme.HrRequestVows
import com.example.amjadcomposeapp.ui.theme.MainColorYankies


@Composable
fun RequestProfileDetails(name: String, ) {
    Card(
        modifier = Modifier
            .padding(vertical = 14.dp)
            .fillMaxWidth()
            .height(70.dp),
        border = BorderStroke(
            1.dp, SolidColor(HrRequestVows)
        ),
        colors = CardDefaults.cardColors(DetailsRowProfileImageBackground)
    ) {
        ProfileRow(img =R.drawable.jarir , name =name,title = stringResource(R.string.applicant))
    }
}


@Composable
fun ProfileRow(img :Int ,title:String, name:String){
    Row(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = img),
            contentDescription = "profile image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)

        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                title, style = TextStyle(
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    color = DateColor
                )
            )
            Text(
                name, style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Alexandria,
                    color = MainColorYankies
                )
            )

        }
    }
}