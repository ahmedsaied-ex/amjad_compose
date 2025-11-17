package com.example.amjadcomposeapp.presentation.components.homeScreenComponents

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
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
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.BottomSheetItem
import com.example.amjadcomposeapp.helpers.UiState
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.BottomSheetDividerColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies
import com.google.android.material.loadingindicator.LoadingIndicator


@Composable
fun ConsultantBottomSheetContent(bottomSheetItems: UiState<List<BottomSheetItem>>,context: Context,onClick: () -> Unit ) {
    Column {
        TitleBottomSheet(onClick)
        HorizontalDivider(
            Modifier.fillMaxWidth(), 1.dp, BottomSheetDividerColor
        )
        when(bottomSheetItems){
            is UiState.Error -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(text = "there is an error", style = TextStyle(color = Color.Red.copy(alpha = .5f)))
                }
            }
            is UiState.Loading ->  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                LoadingIndicator(context)
            }
            is UiState.Success -> {
                LazyColumn {
                    itemsIndexed(bottomSheetItems.data) { index, item ->
                        BottomSheetRow(item)

                        if (index < bottomSheetItems.data.lastIndex) {
                            HorizontalDivider(
                                color = Color(0xFFE0E0E0),
                                thickness = 1.dp,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun TitleBottomSheet(onClick: () -> Unit) {
    Row(modifier = Modifier.padding(start = 16.dp, bottom = 14.dp)) {
        Text(
            stringResource(R.string.title_bottom_bar), style = TextStyle(
                fontSize = 18.sp, fontFamily = Alexandria, fontWeight = FontWeight.SemiBold, color = MainColorYankies
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ic_close),
            contentDescription = "close",
            modifier = Modifier.clickable {
                onClick()
            })
        Spacer(modifier = Modifier.width(16.dp))
    }
}


@Composable
fun BottomSheetRow(bottomSheetItem: BottomSheetItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(bottomSheetItem.icon),
            contentDescription = "bottomSheet item",
            modifier = Modifier.padding(start = 16.dp, end = 14.dp)
        )
        Text(
            bottomSheetItem.label, style = TextStyle(
                fontFamily = Alexandria,
                fontSize = 16.sp,
                color = MainColorYankies
            ),
            textAlign = TextAlign.Center
        )

    }
}
