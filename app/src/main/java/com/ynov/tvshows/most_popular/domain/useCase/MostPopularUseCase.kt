package com.ynov.tvshows.most_popular.domain.useCase


import com.ynov.tvshows.most_popular.domain.model.TvShow
import com.ynov.tvshows.most_popular.domain.repository.MostPopularRepository
import com.ynov.tvshows.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MostPopularUseCase @Inject constructor(
    private val repository: MostPopularRepository
) {
    operator fun invoke(): Flow<Resource<List<TvShow>>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.getMostPopular()
            emit(Resource.Success(response.tv_shows))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }
}