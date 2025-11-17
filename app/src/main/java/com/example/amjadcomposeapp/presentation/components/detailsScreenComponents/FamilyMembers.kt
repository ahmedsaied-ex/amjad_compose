package com.example.amjadcomposeapp.presentation.components.detailsScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.DetailsRowData
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.DepartmentBackground
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.example.amjadcomposeapp.ui.theme.White

@Composable
@Preview(locale = "ar", showBackground = true)
fun FamilyMembers() {
    CustomDetailsStack(
        title = stringResource(R.string.family_members), items = listOf(
            {
                DetailsRowCard(
                    DetailsRowData(
                        title = stringResource(R.string.family_members),
                        image = R.drawable.ic_family_members_profile
                    ), onItemClick = {})

            })
    )
}

@Composable
@Preview
fun CompanyCard() {
    Card(
        modifier = Modifier.Companion
            .padding(bottom = 10.dp)
            .width(300.dp)
            .height(180.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {
        Column {
            CompanyName()
            Department()
            Location()
        }


    }
}

@Composable
fun Location() {
    Column(
        modifier = Modifier.Companion.fillMaxSize(),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(R.drawable.sign_in_out_location),
            contentDescription = "location"
        )
        Text(
            text = stringResource(R.string.attendance_location),
            style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Companion.Normal,
                fontSize = 11.sp,
                color = DateColor
            )
        )
        Text(
            text = stringResource(R.string.pranch),
            style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Companion.Normal,
                fontSize = 11.sp,
                color = MainColorYankies
            )
        )


    }
}

@Composable
fun Department() {
    Row(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .height(30.dp)
            .background(color = DepartmentBackground),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Companion.CenterVertically,

        ) {
        Text(
            stringResource(R.string.department), style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Companion.Normal,
                fontSize = 11.sp,
                color = DateColor

            ),
            modifier = Modifier.Companion.padding(end = 4.dp)
        )
        Text(
            text = stringResource(R.string.department_name),
            style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Companion.Normal,
                fontSize = 11.sp,
                color = MainColorYankies
            )
        )

    }
}


@Composable
fun CompanyName() {
    Row(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Companion.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_company_default_logo),
            contentDescription = "location"
        )
        Spacer(modifier = Modifier.Companion.width(12.dp))
        Text(
            text = stringResource(R.string.company_name), style = TextStyle(
                fontWeight = FontWeight.Companion.Normal,
                fontFamily = Alexandria,
                fontSize = 18.sp,
                color = MainColorYankies
            )
        )
    }
}