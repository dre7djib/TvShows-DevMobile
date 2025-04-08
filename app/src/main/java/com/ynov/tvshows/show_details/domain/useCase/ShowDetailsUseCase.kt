package com.ynov.tvshows.show_details.domain.useCase

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

    operator fun invoke(): Flow<Resource<ShowDetailsResponse>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.getShowDetails()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }

}