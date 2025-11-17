package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CompanyColor
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies


@Composable
fun PersonalityDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismiss}) {

        Box(Modifier.background(Color.White, RoundedCornerShape(10.dp))) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.illu_discover_your_personality),
                    contentDescription = "personality",
                    modifier = Modifier
                        .padding(vertical = 40.dp)
                        .size(250.dp)
                )
                Text(
                    text = stringResource(R.string.discover_your_true_self), style = TextStyle(
                        fontSize = 22.sp,
                        color = MainColorYankies,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = Alexandria
                    ), modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    stringResource(R.string.personality_dialog_body), style = TextStyle(
                        fontSize = 14.sp,
                        color = DateColor,
                        fontFamily = Alexandria,

                        ), modifier = Modifier.padding(bottom = 40.dp), textAlign = TextAlign.Center
                )
                DialogButton(
                    onClick = {
                        onConfirm()
                    },
                    text = stringResource(R.string.discover_your_personality_now),
                    backgroundColor = CompanyColor,
                    contentColor =Color.White
                )
                DialogButton(
                    onClick = {
                        onDismiss()
                    },
                    text = stringResource(R.string.remind_me_later),
                    backgroundColor = CompanyColor.copy(alpha = 0.1f),
                    contentColor =CompanyColor
                )
                Spacer(modifier = Modifier.height(18.dp))



            }
        }


    }
}

@Composable
fun DialogButton(
    onClick: () -> Unit,
    text: String,
    backgroundColor: Color,
    contentColor: Color ,
){
    Button(
        onClick = { onClick() }, shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        ),
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 18.sp,
                color =contentColor
            )
        )

    }
}
