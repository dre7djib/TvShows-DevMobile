package com.ynov.tvshows.show_details.data.service

import com.ynov.tvshows.show_details.data.dto.showDetailsDto
import com.ynov.tvshows.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ShowDetailsService {

    @GET(Constants.SHOW_DETAILS)
    suspend fun getShowDetails(
        @Query("q") showId: Int): showDetailsDto

}