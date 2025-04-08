package com.ynov.tvshows.show_details.domain.repository

import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse

interface ShowDetailsRepository {
    suspend fun getShowDetails(): ShowDetailsResponse
}