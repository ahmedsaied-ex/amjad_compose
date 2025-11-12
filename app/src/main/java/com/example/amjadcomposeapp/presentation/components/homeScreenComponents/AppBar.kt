package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.ui.theme.Alexandria


@Composable
fun AppBar(navController: NavController) {

    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.AppBarr))
            .padding(horizontal = 16.dp)
            .height(68.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Profile(navController)
        Spacer(modifier = Modifier.weight(1f))
        PersonalPoints(navController)
    }


}

@Composable
fun PersonalPoints(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.ic_coins),
        contentDescription = "Sample image",
        modifier = Modifier.size(36.dp).clickable {
            navController.navigate(AppRoute.Calendar::class.qualifiedName!!)
        }
    )
    Spacer(modifier = Modifier.width(6.dp))
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stringResource(R.string.poits), style = TextStyle(
                fontFamily = Alexandria, color = colorResource(id = R.color.date_color)
            )
        )
        Text(
            "1000", style = TextStyle(
                fontFamily = Alexandria,
                color = colorResource(id = R.color.main_color_yankies),
                fontWeight = FontWeight.SemiBold
            )
        )
    }

}

@Composable
fun Profile(navController: NavController) {
    Row(modifier = Modifier.clickable {
        navController.navigate(AppRoute.ProfileDetails::class.qualifiedName!!)
    }) {
        ProfilePicture()
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.height(30.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    stringResource(R.string.hi_moaz), style = TextStyle(
                        fontFamily = Alexandria,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.main_color_yankies)
                    )
                )
                Spacer(modifier = Modifier.width(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.waving_hand),
                    contentDescription = "Sample image",
                    modifier = Modifier.size(30.dp)
                )

            }
            Text(
                stringResource(R.string.date), style = TextStyle(
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    color = colorResource(id = R.color.date_color)
                )
            )
        }
    }
}

@Composable
fun ProfilePicture(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.size(50.dp)
    ) {
        Card(
            modifier = Modifier.size(44.dp), shape = CircleShape,
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.jarir),
                contentDescription = "Profile Picture",
            )
        }
        Card(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.BottomStart),
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF) // Yellow background
            ),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.notofication),
                contentDescription = "Notification Picture",
            )
        }

    }
}

