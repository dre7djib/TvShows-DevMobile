package com.ynov.tvshows.show_details.data.dto

import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse
import java.time.LocalDate
import java.util.Date

data class ShowDetailsResponse(
    val id : Int,
    val name : String,
    val description : String,
    val description_source : String,
    val start_date : LocalDate?,
    val end_date : LocalDate?,
    val country : String,
    val status : String,
    val average_rating : Double,
    val rating_count : Int,
    val genres : List<String>,
    val image_path : String,
    val pictures : List<String>
)

fun ShowDetailsResponse.toShowDetails(): ShowDetailsResponse{
    return ShowDetailsResponse(
        id = id,
        name = name,
        description = description,
        description_source = description_source,
        start_date = start_date,
        end_date = end_date,
        country = country,
        status = status,
        average_rating = average_rating,
        rating_count = rating_count,
        genres = genres,
        image_path = image_path,
        pictures = pictures
    )

}