package com.ynov.tvshows.show_details.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.ynov.tvshows.show_details.presentation.ShowDetailsViewModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowDetailsScreen(
    viewModel: ShowDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()

    // Récupération de l'ID depuis l'intent (à faire ici car pas possible dans ViewModel)
    val showId = remember {
        val idStr = (context as? android.app.Activity)?.intent?.getIntExtra("showId", -1)
        idStr
    }

    // Appel API si non encore lancé
    LaunchedEffect(showId) {
        showId?.let {
            viewModel.getShowDetails(it)
        }
    }

    when {
        state.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.error != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = state.error ?: "Erreur inconnue",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        state.showDetails != null -> {
            val show = state.showDetails!!

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    text = show.name,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Statut: ${show.status} (${show.country})",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                AsyncImage(
                    model = show.image_path,
                    contentDescription = "Image principale",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = show.description,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Genres : ${show.genres.joinToString(", ")}",
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Note moyenne : ${show.average_rating} (${show.rating_count} votes)"
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Diffusé du ${
                        show.start_date?.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    } au ${
                        show.end_date?.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    }",
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Photos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(show.pictures) { picture ->
                        AsyncImage(
                            model = picture,
                            contentDescription = null,
                            modifier = Modifier
                                .height(100.dp)
                                .width(160.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                    }
                }
            }
        }
    }
}
