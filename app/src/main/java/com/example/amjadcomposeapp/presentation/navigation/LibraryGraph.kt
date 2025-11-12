package com.example.amjadcomposeapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.amjadcomposeapp.presentation.components.libraryComponents.LibraryScreen

fun NavGraphBuilder.libraryGraph(navController: NavHostController) {
    composable(AppRoute.Library::class.qualifiedName!!) {

            LibraryScreen(navController)
        }
    }

