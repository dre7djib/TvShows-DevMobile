package com.ynov.tvshows.show_details.domain.model

import java.time.LocalDate

data class ShowDetailsResponse(
    val id : Int,
    val name : String,
    val description : String,
    val description_source : String,
    val start_date : LocalDate,
    val end_date : LocalDate,
    val country : String,
    val status : String,
    val average_rating : Double,
    val rating_count : Int,
    val genres : List<String>,
    val image_path : String,
    val pictures : List<String>
)