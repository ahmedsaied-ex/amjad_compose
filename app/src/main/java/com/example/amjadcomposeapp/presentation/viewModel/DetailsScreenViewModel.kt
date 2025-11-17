package com.example.amjadcomposeapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amjadcomposeapp.domain.models.EmojisModel
import com.example.amjadcomposeapp.domain.repository.DetailsScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val repository: DetailsScreenRepository
) : ViewModel() {
    private val _emojis = MutableStateFlow<List<EmojisModel>>(emptyList())
    val emojis: StateFlow<List<EmojisModel>> = _emojis


    init {
        viewModelScope.launch {
            _emojis.value = repository.getEmojis()
        }
    }

}