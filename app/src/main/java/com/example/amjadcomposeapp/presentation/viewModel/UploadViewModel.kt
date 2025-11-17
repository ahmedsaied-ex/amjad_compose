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

    private val maxFiles = 5   // ← الحد الأقصى

    fun checkPermission() {
        permissionGranted.value = filePickerHelper.hasPermission()
    }

    fun requestPermission(permissionLauncher: (String) -> Unit) {
        val permission = filePickerHelper.getReadPermission()
        permissionLauncher(permission)
    }

    fun onFilePicked(uri: Uri,context: Context) {

        // لو وصل 5 ملفات → ما تضيفش أي جديد
        if (selectedFiles.value.size >= maxFiles) {
            showToast(context)
            return
        }

        val fileData = filePickerHelper.getFileData(uri)


        selectedFiles.value = selectedFiles.value + fileData
    }

    fun removeFile(fileData: FileData) {
        selectedFiles.value = selectedFiles.value.filter { it != fileData }
    }

    fun canAddMoreFiles(): Boolean = selectedFiles.value.size < maxFiles

    private fun showToast(context: Context) {
        Toast.makeText(
            context,
            "you have reached the maximum capicity with 5 files",
            Toast.LENGTH_SHORT
        ).show()

    }

}
