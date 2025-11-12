package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria

@Composable
fun CostumeAppBar(navController: NavController, icon:Int, text:Int) {
    Row(modifier = Modifier.height(44.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(icon), contentDescription = "back to requests", modifier = Modifier.clickable{
                navController.popBackStack()
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            stringResource(text), style = TextStyle(
                fontSize = 16.sp,
                fontFamily = Alexandria,
                color = colorResource(R.color.main_color_yankies)
            )
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}