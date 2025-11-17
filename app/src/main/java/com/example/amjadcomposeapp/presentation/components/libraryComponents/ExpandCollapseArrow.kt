package com.example.amjadcomposeapp.presentation.components.libraryComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.amjadcomposeapp.R

@Composable
fun ExpandCollapseArrow(expanded: Boolean, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(if (expanded) R.drawable.ic_collapse else R.drawable.ic_expand),
            contentDescription = "expand arrows",
            modifier = Modifier.clickable { onClick() }
        )
    }
}
