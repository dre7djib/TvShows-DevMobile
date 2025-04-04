package com.ynov.tvshows.most_popular.data.dto

import com.google.gson.annotations.SerializedName
import com.ynov.tvshows.most_popular.domain.model.TvShow

data class TvShowDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("network")
    val network: String,
    @SerializedName("image_thumbnail_path")
    val image: String,
    @SerializedName("start_date")
    val startDate: String,
    @SerializedName("end_date")
    val endDate: String?,
    @SerializedName("status")
    val status: String,
)

fun TvShowDTO.toTvShow(): TvShow {
    return TvShow(
        id = id,
        name = name,
        permalink = permalink,
        country = country,
        network = network,
        image_thumbnail_path = image,
        start_date = startDate,
        end_date = endDate ?: "",
        status = status
    )
}