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
        id = this.id,
        name = this.name,
        description = this.description,
        description_source = this.description_source,
        start_date = this.start_date,
        end_date = this.end_date,
        country = this.country,
        status = this.status,
        average_rating = this.average_rating,
        rating_count = this.rating_count,
        genres = this.genres,
        image_path = this.image_path,
        pictures = this.pictures
    )

}