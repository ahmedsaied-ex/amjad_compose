package com.example.amjadcomposeapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.BottomNavItem
import com.example.amjadcomposeapp.ui.theme.CompanyColor

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", R.drawable.ic_home_fill, R.drawable.ic_home_outline, AppRoute.Home),
        BottomNavItem("Offers", R.drawable.ic_offers_fill, R.drawable.ic_offers_outline, AppRoute.Offers),
        BottomNavItem("Vendors", R.drawable.ic_vendors_fill, R.drawable.ic_vendors_outline, AppRoute.Vendors),
        BottomNavItem("NewsAndSurveys", R.drawable.ic_news_fill, R.drawable.ic_news_outline, AppRoute.News),
        BottomNavItem("MyConsultant", R.drawable.ic_my_consultant_fill, R.drawable.ic_my_consultant_outline, AppRoute.MyConsultant)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val companyColor = CompanyColor


    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp,
        modifier = Modifier.height(60.dp)
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route::class.qualifiedName

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(
                        if (selected) companyColor.copy(alpha = 0.04f)
                        else Color.Transparent
                    )
                    .noRippleClickable {
                        navController.navigate(item.route::class.qualifiedName!!) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Top indicator line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(3.dp)
                            .background(
                                if (selected) companyColor else Color.Transparent,
                                shape = RoundedCornerShape(bottomStart = 3.dp, bottomEnd = 3.dp)
                            )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(
                            id = if (selected) item.selectedIcon else item.unSelectedIcon
                        ),
                        contentDescription = item.title,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@SuppressLint("RememberInComposition")
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    this.then(
        Modifier
            .clip(RoundedCornerShape(0.dp))
            .background(Color.Transparent)
            .clickable(
                indication = null,
                interactionSource = androidx.compose.foundation.interaction.MutableInteractionSource()
            ) { onClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            BottomNavigationBar(navController = navController)
        }
    }
}



