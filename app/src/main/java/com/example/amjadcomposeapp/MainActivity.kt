package com.example.amjadcomposeapp

import MainNavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.ui.theme.AmjadComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.amjadcomposeapp.presentation.navigation.BottomNavigationBar
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val activity = LocalActivity.current

    AmjadComposeAppTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route

            val bottomNavRoutes = listOf(
                AppRoute.Home::class.qualifiedName!!,
                AppRoute.Offers::class.qualifiedName!!,
                AppRoute.Vendors::class.qualifiedName!!,
                AppRoute.News::class.qualifiedName!!,
                AppRoute.MyConsultant::class.qualifiedName!!
            )

            val showBottomBar = currentRoute in bottomNavRoutes

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    if (showBottomBar) {
                        BottomNavigationBar(navController = navController)
                    }
                }
            ) { innerPadding ->
                MainNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }

            // 🔥 BackHandler الصحيح
            BackHandler {
                activity!!.finishAndRemoveTask()
            }
        }
    }
}
