package com.ynov.tvshows.most_popular.data.dto

import com.ynov.tvshows.most_popular.domain.model.MostPopularResponse

data class MostPopularResponseDTO(
    val page: Int,
    val pages: Int,
    val total: Int,
    val tv_shows: List<TvShowDTO>
)

fun MostPopularResponseDTO.toMostPopularResponse(): MostPopularResponse {
    return MostPopularResponse(
        page = page,
        pages = pages,
        total = total,
        tv_shows = tv_shows.map { tv_showsdto ->
            tv_showsdto.toTvShow()
        }
    )
}