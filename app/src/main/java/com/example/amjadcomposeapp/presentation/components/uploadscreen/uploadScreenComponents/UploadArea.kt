package com.example.amjadcomposeapp.presentation.components.uploadscreen.uploadScreenComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.presentation.components.uploadscreen.TextAttachmentRow
import com.example.amjadcomposeapp.ui.theme.Alexandria
import com.example.amjadcomposeapp.ui.theme.CompanyColor
import com.example.amjadcomposeapp.ui.theme.DateColor


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
                color = CompanyColor,
                fontWeight = FontWeight.Medium,
                fontFamily = Alexandria,
                fontSize = 14.sp
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextAttachmentRow(
            title = stringResource(R.string.supported_files),
            value = stringResource(R.string.supported_types_kinds),
            titleColor = DateColor,
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