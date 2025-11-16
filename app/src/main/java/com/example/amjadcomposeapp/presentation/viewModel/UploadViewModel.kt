package com.example.amjadcomposeapp.presentation.viewModel

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.amjadcomposeapp.domain.models.FileData
import com.example.amjadcomposeapp.utils.FilePickerHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class UploadViewModel @Inject constructor(
    private val filePickerHelper: FilePickerHelper
): ViewModel() {

    // بدل selectedFile واحد، نخليها قائمة
    val selectedFiles = mutableStateOf<List<FileData>>(emptyList())
    val permissionGranted = mutableStateOf(false)

    fun checkPermission() {
        permissionGranted.value = filePickerHelper.hasPermission()
    }

    fun requestPermission(permissionLauncher: (String) -> Unit) {
        val permission = filePickerHelper.getReadPermission()
        permissionLauncher(permission)
    }

    fun onFilePicked(uri: Uri) {
        val fileData = filePickerHelper.getFileData(uri)
        // اضيف الملف الجديد للقائمة
        selectedFiles.value = selectedFiles.value + fileData
    }

    fun removeFile(fileData: FileData) {
        selectedFiles.value = selectedFiles.value.filter { it != fileData }
    }
}
