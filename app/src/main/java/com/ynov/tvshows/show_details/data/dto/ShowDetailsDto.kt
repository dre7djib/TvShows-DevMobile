package com.ynov.tvshows.show_details.data.dto

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import com.google.gson.annotations.SerializedName
import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse

data class showDetailsDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("description_source")
    val description_source: String,
    @SerializedName("start_date")
    val start_date: String,
    @SerializedName("end_date")
    val end_date: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("average_rating")
    val average_rating: String,
    @SerializedName("rating_count")
    val rating_count: Int,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("image_path")
    val image_path: String,
    @SerializedName("pictures")
    val pictures: List<String>
)

// @RequiresApi(Build.VERSION_CODES.O)
fun showDetailsDto.toShowDetails(): ShowDetailsResponse {

    return ShowDetailsResponse(
        id = id,
        name = name,
        description = description,
        description_source = description_source,
        start_date = LocalDate.parse(start_date),
        end_date = LocalDate.parse(end_date),
        country = country,
        status = status,
        average_rating = average_rating.toDouble(),
        rating_count = rating_count,
        genres = genres,
        image_path = image_path,
        pictures = pictures
    )
}