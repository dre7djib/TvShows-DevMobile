package com.ynov.tvshows.most_popular.domain.model

data class MostPopularResponse(
    val page: Int,
    val pages: Int,
    val total: Int,
    val tv_shows: List<TvShow>
)