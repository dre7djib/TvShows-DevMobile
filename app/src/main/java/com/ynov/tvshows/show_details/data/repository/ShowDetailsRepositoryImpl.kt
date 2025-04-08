package com.ynov.tvshows.show_details.data.repository

import android.os.Build
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
    override suspend fun getShowDetails() : ShowDetailsResponse {
        return service.getShowDetails(29560).toShowDetails()
    }
}