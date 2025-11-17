package com.example.amjadcomposeapp.utils

import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.OpenableColumns
import androidx.core.content.ContextCompat
import com.example.amjadcomposeapp.domain.models.FileData
import dagger.hilt.android.qualifiers.ApplicationContext
import java.text.DecimalFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilePickerHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {


    fun hasPermission(): Boolean {
        val permission = getReadPermission()
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }

     fun getFileSizeInBytes(uri: Uri, context: Context): Long {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        val sizeIndex = cursor?.getColumnIndex(OpenableColumns.SIZE) ?: -1
        cursor?.moveToFirst()

        val size = if (sizeIndex >= 0) cursor?.getLong(sizeIndex) else null

        cursor?.close()
        return size ?: 0L
    }



    fun getReadPermission(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            android.Manifest.permission.READ_MEDIA_IMAGES
        else
            android.Manifest.permission.READ_EXTERNAL_STORAGE
    }


    fun getFileData(uri: Uri): FileData {
        var name = "Unknown"
        var size = "0 KB"

        context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)

                if (nameIndex >= 0) name = cursor.getString(nameIndex)
                if (sizeIndex >= 0) {
                    val sizeInBytes = cursor.getLong(sizeIndex)
                    val df = DecimalFormat("#.##")

                    size = when {
                        sizeInBytes < 1024 -> "$sizeInBytes B"
                        sizeInBytes < 1024 * 1024 -> "${df.format(sizeInBytes / 1024.0)} KB"
                        sizeInBytes < 1024 * 1024 * 1024 -> "${df.format(sizeInBytes / (1024.0 * 1024.0))} MB"
                        else -> "${df.format(sizeInBytes / (1024.0 * 1024.0 * 1024.0))} GB"
                    }
                }
            }
        }

        return FileData(uri, name, size)
    }
}
