package com.ynov.tvshows.most_popular.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynov.tvshows.most_popular.domain.model.TvShow
import com.ynov.tvshows.most_popular.domain.useCase.MostPopularUseCase
import com.ynov.tvshows.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MostPopularViewModel @Inject constructor(
    private val useCase: MostPopularUseCase
) : ViewModel() {

    private val _state : MutableStateFlow<EverythingState> = MutableStateFlow(EverythingState())
    val state : StateFlow<EverythingState> = _state

    fun getEverything() = viewModelScope.launch(Dispatchers.IO) {

        useCase().collectLatest { everythingState ->
            when(everythingState) {
                is Resource.Success -> {

                    withContext(Dispatchers.Main) {
                        _state.value = EverythingState(articles = everythingState.data ?: emptyList())
                    }

                    //_state.value = EverythingState(articles = everythingState.data ?: emptyList())
                }
                is Resource.Error -> {
                    //_state.value = EverythingState(error = "An unexpected error occured")
                    //Log.e("EverythingViewModel", "getEverything: ${everythingState.message}")

                    withContext(Dispatchers.Main) {
                        _state.value = EverythingState(error = "${everythingState.message}")
                    }
                    Log.e("EverythingViewModel", "getEverything: ${everythingState.message}")

                }
                is Resource.Loading -> {
                    //_state.value = EverythingState(isLoading = true)

                    withContext(Dispatchers.Main) {
                        _state.value = EverythingState(isLoading = true)
                    }
                }
            }
        }
    }
}

class EverythingState(
    val articles : List<TvShow> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)