package com.example.amjadcomposeapp.presentation.components.uploadscreen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
import com.example.amjadcomposeapp.ui.theme.AttachmentButtonColor
import com.example.amjadcomposeapp.ui.theme.DateColor
import com.example.amjadcomposeapp.ui.theme.MainColorYankies

@Composable
fun UploadScreen(viewModel: UploadViewModel, navController: NavController) {


    val selectedFile = viewModel.selectedFiles.value


    val filePickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenMultipleDocuments()
    ) { uris: List<Uri> ->
        uris.forEach { uri -> viewModel.onFilePicked(uri) }
    }


    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        viewModel.permissionGranted.value = isGranted
        if (isGranted) {
            filePickerLauncher.launch(
                arrayOf("application/pdf", "image/jpeg", "image/png")
            )
        }
    }


    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier

                .fillMaxSize()
        ) {

            CostumeAppBar(
                navController = navController,
                icon = R.drawable.ic_close,
                text = R.string.attache_documentes
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                // Title
                item {
                    Text(
                        stringResource(R.string.required_Attachement_text),
                        style = TextStyle(
                            color = MainColorYankies,
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
                                if (viewModel.permissionGranted.value) {
                                    filePickerLauncher.launch(
                                        arrayOf("application/pdf", "image/jpeg", "image/png")
                                    )
                                } else {
                                    viewModel.requestPermission { permission ->
                                        permissionLauncher.launch(permission)
                                    }
                                }
                            },
                        color = DateColor,
                        strokeWidth = 1.dp,
                        dashLength = 4.dp,
                        cornerRadius = 12.dp
                    ) {
                        UploadingAttachmentArea(modifier = Modifier)
                    }
                }

                // Selected file card
                selectedFile.forEach { file ->
                    item {
                        AttachmentCard(
                            fileName = file.name,
                            fileSize = file.size,
                            onRemove = { viewModel.removeFile(file) }
                        )
                    }
                }

                // Notes TextField
                item {
                    NotesTextField()
                    Spacer(modifier = Modifier.height(60.dp))
                }


            }


        }
        Button(
            onClick = { /* TODO: upload file */ },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AttachmentButtonColor,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter)

        ) {
            Text(
                stringResource(R.string.attache_document),
                style = TextStyle(
                    color = Color.White,
                    fontFamily = Alexandria,
                    fontSize = 18.sp
                )
            )
        }
    }
}
