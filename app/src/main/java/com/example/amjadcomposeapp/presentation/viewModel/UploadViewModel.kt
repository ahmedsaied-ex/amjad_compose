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
    val selectedFile = mutableStateOf<FileData?>(null)

    fun onFilePicked(uri: Uri) {
        selectedFile.value = filePickerHelper.getFileData(uri)
    }
}
