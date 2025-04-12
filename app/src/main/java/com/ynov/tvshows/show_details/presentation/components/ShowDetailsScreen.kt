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
import com.ynov.tvshows.show_details.presentation.ShowDetailsState
import com.ynov.tvshows.show_details.presentation.ShowDetailsViewModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowDetailsScreen(state: ShowDetailsState) {
    // Afficher le chargement pendant la récupération des données
    if (state.isLoading) {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize())
    } else if (state.error != null) {
        // Afficher l'erreur s'il y en a une
        Text("Error: ${state.error}", color = MaterialTheme.colorScheme.error, modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
    } else {
        // Afficher les détails de l'émission si la requête réussit
        state.showDetails?.let {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Title: ${it.name}")
                Text("Description: ${it.description}")
                // Tu peux ajouter d'autres informations ici
            }
        }
    }
}