package com.ynov.tvshows.show_details.data.dto

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.LocalDate
import com.google.gson.annotations.SerializedName
import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse
import java.time.format.DateTimeParseException

/*data class showDetailsDto(
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
    val country: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("average_rating")
    val average_rating: String?,
    @SerializedName("rating_count")
    val rating_count: Int,
    @SerializedName("genres")
    val genres: List<String>?,
    @SerializedName("image_path")
    val image_path: String?,
    @SerializedName("pictures")
    val pictures: List<String>?
)
*/

data class showDetailsDto(
    val tvShow: TvShowDto
)

data class TvShowDto(
    val id: Int,
    val name: String,
    val permalink: String,
    val url: String,
    val description: String,
    val description_source:String,
    val start_date :String,
    val end_date : String,
    val country :String,
    val status :String,
    val average_rating :String,
    val rating_count :Int,
    val genres :List<String>,
    val image_path :String,
    val pictures :List<String>,
    // Ajoute les autres champs que tu as dans la réponse
)

// @RequiresApi(Build.VERSION_CODES.O)
fun showDetailsDto.toShowDetails(): ShowDetailsResponse {

    val parsedStartDate = tvShow.start_date.takeIf { !it.isNullOrBlank() }?.let { LocalDate.parse(it) }
    val parsedEndDate = tvShow.end_date.takeIf { !it.isNullOrBlank() }?.let { LocalDate.parse(it) }
    val parsedRating = tvShow.average_rating?.toDoubleOrNull() ?: 0.0

    Log.d("toShowDetails", "DTO received: $this")
    Log.d("toShowDetails", "Parsed start date: $parsedStartDate")
    Log.d("toShowDetails", "Parsed end date: $parsedEndDate")
    Log.d("toShowDetails", "Parsed rating: $parsedRating")

    return ShowDetailsResponse(
        id = tvShow.id,
        name = tvShow.name ?: "Nom inconnu",  // Valeur par défaut si null
        description = tvShow.description ?: "Description inconnue",  // Valeur par défaut si null
        description_source = tvShow.description_source ?: "Source inconnue",  // Valeur par défaut si null
        start_date = parsedStartDate,
        end_date = parsedEndDate,
        country = tvShow.country ?: "Inconnue",
        status = tvShow.status ?: "Inconnu",
        average_rating = parsedRating,
        rating_count = tvShow.rating_count,
        genres = tvShow.genres ?: emptyList(),
        image_path = tvShow.image_path ?: "",
        pictures = tvShow.pictures ?: emptyList()
    )
}

fun showDetailsDto.toDomain(): ShowDetailsResponse {

    val parsedStartDate = tvShow.start_date.takeIf { !it.isNullOrBlank() }?.let { LocalDate.parse(it) }
    val parsedEndDate = tvShow.end_date.takeIf { !it.isNullOrBlank() }?.let { LocalDate.parse(it) }
    val parsedRating = tvShow.average_rating?.toDoubleOrNull() ?: 0.0

    return ShowDetailsResponse(
        id = this.tvShow.id,
        name = this.tvShow.name,
        description = this.tvShow.description,
        description_source = this.tvShow.description_source,
        start_date = parsedStartDate,
        end_date = parsedEndDate,
        country = this.tvShow.country,
        status = this.tvShow.status,
        average_rating = parsedRating,
        rating_count = this.tvShow.rating_count,
        genres = this.tvShow.genres,
        image_path = this.tvShow.image_path,
        pictures = this.tvShow.pictures
    )
}