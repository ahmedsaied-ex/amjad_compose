package com.example.amjadcomposeapp.presentation.viewModel

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.amjadcomposeapp.domain.models.FileData
import com.example.amjadcomposeapp.utils.FilePickerHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject@HiltViewModel


class UploadViewModel @Inject constructor(
    private val filePickerHelper: FilePickerHelper
): ViewModel() {

    val selectedFiles = mutableStateOf<List<FileData>>(emptyList())
    val permissionGranted = mutableStateOf(false)

    private val maxFiles = 5

    fun requestPermission(permissionLauncher: (String) -> Unit) {
        val permission = filePickerHelper.getReadPermission()
        permissionLauncher(permission)
    }
    fun onFilePicked(uri: Uri, context: Context) {

        if (selectedFiles.value.size >= maxFiles) {
            showToast(context,"Maximum number of files reached!")
            return
        }

        val fileSize = filePickerHelper.getFileSizeInBytes(uri, context)
        val maxSize = 5 * 1024 * 1024

        if (fileSize > maxSize) {
            showToast(context,"File size exceeds the limit!")
            return
        }

        val fileData = filePickerHelper.getFileData(uri)
        selectedFiles.value += fileData
    }


    fun removeFile(fileData: FileData) {
        selectedFiles.value = selectedFiles.value.filter { it != fileData }
    }

    fun canAddMoreFiles(): Boolean = selectedFiles.value.size < maxFiles

    private fun showToast(context: Context,errorMessage:String) {
        Toast.makeText(
            context,
            errorMessage,
            Toast.LENGTH_SHORT
        ).show()
    }

}
