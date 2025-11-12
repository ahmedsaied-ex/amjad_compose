package com.example.amjadcomposeapp.presentation.components.uploadscreen

import android.app.Activity
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.DashedBorderBox
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.CostumeAppBar
import com.example.amjadcomposeapp.presentation.components.uploadscreen.uploadScreenComponents.AttachmentCard
import com.example.amjadcomposeapp.presentation.components.uploadscreen.uploadScreenComponents.NotesTextField
import com.example.amjadcomposeapp.presentation.components.uploadscreen.uploadScreenComponents.UploadingAttachmentArea
import com.example.amjadcomposeapp.presentation.viewModel.UploadViewModel
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.utils.FilePickerHelper

@Composable
fun UploadScreen(viewModel: UploadViewModel, navController: NavController) {
    val context = LocalContext.current
    val selectedFile = viewModel.selectedFile.value
    val filePickerHelper = FilePickerHelper(context)

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.onFilePicked(it) }
    }

    Column(modifier = Modifier
        .background(Color.White)
        .padding(horizontal = 16.dp)
        .fillMaxSize()) {

        CostumeAppBar(
            navController = navController,
            icon = R.drawable.ic_close,
            text = R.string.attache_documentes
        )

        LazyColumn(
            modifier = Modifier
                .background(Color.White)
               ,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Title
            item {
                Text(
                    stringResource(R.string.required_Attachement_text),
                    style = TextStyle(
                        color = colorResource(R.color.main_color_yankies),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        fontFamily = Alexandria
                    )
                )
            }

            // File Picker
            item {
                DashedBorderBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            if (filePickerHelper.hasPermission()) {
                                launcher.launch("*/*")
                            } else {
                                filePickerHelper.requestPermission(context as Activity)
                            }
                        },
                    color = colorResource(R.color.date_color),
                    strokeWidth = 1.dp,
                    dashLength = 4.dp,
                    cornerRadius = 12.dp
                ) {
                    UploadingAttachmentArea(modifier = Modifier)
                }
            }

            // AttachmentCard
            selectedFile?.let {
                item {
                    AttachmentCard(fileName = it.name, fileSize = it.size)
                }
            }

            // Notes TextField
            item {
                NotesTextField()

            }


        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /* TODO */ },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.attachment_button_color),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                "إرفاق الوثيقة",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = Alexandria,
                    fontSize = 18.sp
                )
            )
        }
    }
}

