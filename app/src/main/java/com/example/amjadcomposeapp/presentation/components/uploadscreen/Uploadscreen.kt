package com.example.amjadcomposeapp.presentation.components.uploadscreen

import android.app.Activity
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.FileData
import com.example.amjadcomposeapp.presentation.components.calendarScreen.calendarComponents.DashedBorderBox
import com.example.amjadcomposeapp.presentation.components.requestScreenComponents.CostumeAppBar
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


@Composable
fun NotesTextField() {

    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= 500) text = it
            },
            modifier = Modifier
                .fillMaxWidth()

                .height(240.dp),
            textStyle = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                textDirection = TextDirection.ContentOrRtl // Arabic support
            ),
            placeholder = {
                Text(
                    text = "...أكتب ملاحظاتك هنا",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            },
            maxLines = Int.MAX_VALUE,
            shape = RoundedCornerShape(12.dp),

            )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Text(
                "اختيارى", style = TextStyle(
                    fontSize = 12.sp,
                    color = colorResource(R.color.date_color),
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Light,

                    )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${text.length}/500",
                fontSize = 14.sp,
                color = if (text.length >= 500) Color.Red else Color.Gray,
            )

        }
    }
}


@Composable
fun AttachmentCard(fileName: String, fileSize: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = 2.dp, color = colorResource(R.color.dashed_color)
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.reason_card_background)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.ic_pdf),
                contentDescription = "Pdf image", modifier = Modifier
                    .height(30.dp)
                    .width(23.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(11f)) {
                Text(
                    fileName, style = TextStyle(
                        color = colorResource(R.color.main_color_yankies),
                        fontWeight = FontWeight.Medium,
                        fontFamily = Alexandria,
                        fontSize = 14.sp

                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    fileSize, style = TextStyle(
                        color = colorResource(R.color.pdf_size_color),
                        fontFamily = Alexandria,
                        fontSize = 14.sp
                    ),


                )
            }

            Box(modifier = Modifier.weight(1f)) {
                Image(
                    painterResource(R.drawable.ic_delete),
                    contentDescription = "delete attachment icon",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterEnd)

                )
            }


        }

    }
}

@Composable
fun UploadingAttachmentArea(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.upload_file_ic), contentDescription = "upload file image"
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            stringResource(R.string.pick_attachments), style = TextStyle(
                color = colorResource(R.color.company_color),
                fontWeight = FontWeight.Medium,
                fontFamily = Alexandria,
                fontSize = 14.sp
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextAttachmentRow(
            title = stringResource(R.string.supported_files),
            value = stringResource(R.string.supported_types_kinds),
            titleColor = R.color.date_color,
            valueColor = R.color.attachment_kind_color
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextAttachmentRow(
            title = stringResource(R.string.limited_size),
            value = stringResource(R.string.size_of_attachment),
            titleColor = R.color.date_color,
            valueColor = R.color.attachment_kind_color
        )


    }
}

@Composable
fun TextAttachmentRow(title: String, value: String, titleColor: Int, valueColor: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,

        ) {
        Text(
            title, style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Normal,
                fontSize = 11.sp,
                color = colorResource(titleColor)
            )
        )
        Text(
            value, style = TextStyle(
                fontFamily = Alexandria,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                color = colorResource(valueColor)
            )
        )
    }
}