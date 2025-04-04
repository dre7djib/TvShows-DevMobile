package com.ynov.tvshows.most_popular.data.repository

import javax.inject.Inject
import com.ynov.tvshows.most_popular.data.dto.toMostPopularResponse
import com.ynov.tvshows.most_popular.data.service.MostPopularService
import com.ynov.tvshows.most_popular.domain.model.MostPopularResponse
import com.ynov.tvshows.most_popular.domain.repository.MostPopularRepository

class MostPopularRepositoryImpl @Inject constructor(
    private val service: MostPopularService
) : MostPopularRepository {
    override suspend fun getMostPopular(): MostPopularResponse {
        return service.getMostPopular().toMostPopularResponse()
    }
}