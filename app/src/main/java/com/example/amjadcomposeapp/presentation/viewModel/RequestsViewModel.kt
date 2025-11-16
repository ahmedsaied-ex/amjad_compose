package com.example.amjadcomposeapp.presentation.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amjadcomposeapp.domain.models.RequestItem
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.domain.use_case.GetRequestsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class FilterOption { ACCEPTED, REJECTED, PENDING }

data class RequestsUiState(
    val allItems: List<RequestItem> = emptyList(),
    val filteredItems: List<RequestItem> = emptyList(),
    val selectedFilter: FilterOption = FilterOption.PENDING,
    val isLoading: Boolean = true,
)@HiltViewModel
class RequestsViewModel @Inject constructor(
    private val getRequestsUseCase: GetRequestsUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow(RequestsUiState())
    val uiState: StateFlow<RequestsUiState> = _uiState.asStateFlow()

    private val _selectedRequest = MutableStateFlow<RequestItem?>(null)
    val selectedRequest: StateFlow<RequestItem?> = _selectedRequest

    init {
        loadRequests()
    }

    private fun loadRequests() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val result = getRequestsUseCase()
            val initList = result.filter { it.status == RequestStatus.PENDING }

            _uiState.update {
                it.copy(
                    allItems = result,
                    filteredItems = initList,
                    isLoading = false
                )
            }
        }
    }

    fun onFilterSelected(filter: FilterOption) {
        val all = _uiState.value.allItems
        val filtered = when (filter) {
            FilterOption.ACCEPTED -> all.filter { it.status == RequestStatus.ACCEPTED }
            FilterOption.REJECTED -> all.filter { it.status == RequestStatus.REJECTED }
            FilterOption.PENDING -> all.filter { it.status == RequestStatus.PENDING }
        }

        _uiState.update {
            it.copy(selectedFilter = filter, filteredItems = filtered)
        }
    }


    fun selectRequest(item: RequestItem) {
        _selectedRequest.value = item
    }
}
