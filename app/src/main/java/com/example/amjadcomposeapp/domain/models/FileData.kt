package com.example.amjadcomposeapp.domain.models

import android.net.Uri

data class FileData(
    val uri: Uri,
    val name: String,
    val size: String
)
