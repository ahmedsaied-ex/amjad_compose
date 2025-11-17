package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.presentation.navigation.AppRoute
import com.example.amjadcomposeapp.presentation.viewModel.MediaViewModel

@Composable
fun LibraryRequestRow(
    item: MediaRequest,
    navController: NavController,
    viewModel: MediaViewModel = viewModel()
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                viewModel.selectRequest(item)
                navController.navigate(AppRoute.LibraryContent::class.qualifiedName!!)
            },
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            LibraryRequestMainRow(item, expanded)
            ExpandCollapseArrow(expanded = expanded, onClick = { expanded = !expanded })
        }
    }
}
