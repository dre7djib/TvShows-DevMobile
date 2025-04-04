package com.ynov.tvshows.most_popular.data.service

import com.ynov.tvshows.most_popular.data.dto.MostPopularResponseDTO
import com.ynov.tvshows.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MostPopularService {

    @GET(Constants.MOST_POPULAR)
    suspend fun getMostPopular(
        @Query(Constants.PAGE) page: Int = 1
    ): MostPopularResponseDTO
}