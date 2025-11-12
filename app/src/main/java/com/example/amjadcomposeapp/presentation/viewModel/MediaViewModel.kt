package com.example.amjadcomposeapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.models.MediaType
import com.example.amjadcomposeapp.domain.use_case.GetMediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class MediaFilter { AUDIO, VIDEO, ARTICLES }

data class MediaUiState(
    val allMedia: List<MediaRequest> = emptyList(),
    val filteredMedia: List<MediaRequest> = emptyList(),
    val selectedFilter: MediaFilter = MediaFilter.ARTICLES,
    val isLoading: Boolean = true
)

@HiltViewModel
class MediaViewModel @Inject constructor(
    private val getMediaUseCase: GetMediaUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MediaUiState())
    val uiState: StateFlow<MediaUiState> = _uiState.asStateFlow()

    init {
        loadMedia()
    }

    private fun loadMedia() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val mediaList = getMediaUseCase.invoke()
            val initList = mediaList.filter { it.type == MediaType.ARTICLES }

            _uiState.update {
                it.copy(
                    allMedia = mediaList,
                    filteredMedia = initList,
                    isLoading = false
                )
            }
        }
    }

    fun onFilterSelected(filter: MediaFilter) {
        val all = _uiState.value.allMedia
        val filtered = when (filter) {
            MediaFilter.AUDIO -> all.filter { it.type == MediaType.AUDIO }
            MediaFilter.VIDEO -> all.filter { it.type == MediaType.VIDEO }
            MediaFilter.ARTICLES -> all.filter { it.type == MediaType.ARTICLES }

        }

        _uiState.update {
            it.copy(selectedFilter = filter, filteredMedia = filtered)
        }
    }
}
