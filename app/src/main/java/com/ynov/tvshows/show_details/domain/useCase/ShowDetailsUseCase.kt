package com.ynov.tvshows.show_details.domain.useCase

import android.util.Log
import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse
import com.ynov.tvshows.show_details.domain.repository.ShowDetailsRepository
import com.ynov.tvshows.utils.Resource
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


class ShowDetailsUseCase @Inject constructor(
    private val repository: ShowDetailsRepository
){

    operator fun invoke(showId: String): Flow<Resource<ShowDetailsResponse>> = flow {
        Log.d("ShowDetailsUseCase", "Fetching show details for showId from use case: $showId")
        emit(Resource.Loading())
        try {
            val response = repository.getShowDetails(showId)
            Log.d("API Response", "Raw response: $response")
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
            Log.e("ShowDetailsUseCase", "Exception", e)
        }
    }


}