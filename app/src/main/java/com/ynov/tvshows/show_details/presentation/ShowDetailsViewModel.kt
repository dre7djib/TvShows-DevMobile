package com.ynov.tvshows.show_details.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse
import com.ynov.tvshows.show_details.domain.useCase.ShowDetailsUseCase
import com.ynov.tvshows.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDetailsViewModel @Inject constructor(
    private val useCase: ShowDetailsUseCase
) : ViewModel() {

    private val _state : MutableStateFlow<ShowDetailsState> = MutableStateFlow(ShowDetailsState())
    val state : StateFlow<ShowDetailsState> = _state

    fun getShowDetails(showId: String) = viewModelScope.launch(Dispatchers.IO) {
        Log.d("ShowDetailsViewModel", "Fetching show details for showId: $showId")
        useCase(showId).collectLatest { showDetailsState ->
            when(showDetailsState) {
                is Resource.Success -> {
                    Log.d("ShowDetailsViewModel", "Data received: ${showDetailsState.data}")
                    _state.value = ShowDetailsState(showDetails = showDetailsState.data)
                }
                is Resource.Error -> {
                    Log.e("ShowDetailsViewModel", "Error loading show details: ${showDetailsState.message}")
                    _state.value = ShowDetailsState(error = showDetailsState.message ?: "An unexpected error occured")                }
                is Resource.Loading -> {
                    _state.value = ShowDetailsState(isLoading = true)
                    }
                }
            }

    }
}

class ShowDetailsState(
    val showDetails : ShowDetailsResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)