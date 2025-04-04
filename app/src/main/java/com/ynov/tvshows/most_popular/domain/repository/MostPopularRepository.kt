package com.ynov.tvshows.most_popular.domain.repository

import com.ynov.tvshows.most_popular.domain.model.MostPopularResponse

interface MostPopularRepository {
    suspend fun getMostPopular(): MostPopularResponse
}