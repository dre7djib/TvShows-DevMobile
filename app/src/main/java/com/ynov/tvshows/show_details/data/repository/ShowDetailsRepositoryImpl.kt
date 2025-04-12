package com.ynov.tvshows.show_details.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import javax.inject.Inject
import com.ynov.tvshows.show_details.data.dto.toShowDetails
import com.ynov.tvshows.show_details.data.service.ShowDetailsService
import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse
import com.ynov.tvshows.show_details.domain.repository.ShowDetailsRepository

class ShowDetailsRepositoryImpl @Inject constructor(
    private val service: ShowDetailsService
) : ShowDetailsRepository {
    // @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getShowDetails(showId: String) : ShowDetailsResponse {
        Log.d("ShowDetailsRepository", "show id in repoImpl: $showId")
        val showDetailsDto = service.getShowDetails(showId)
        Log.d("ShowDetailsRepository", "API response: $showDetailsDto")
        val showDetails = showDetailsDto.toShowDetails()
        Log.d("ShowDetailsRepository", "Domain model received: $showDetails")

        return showDetails
    }
}