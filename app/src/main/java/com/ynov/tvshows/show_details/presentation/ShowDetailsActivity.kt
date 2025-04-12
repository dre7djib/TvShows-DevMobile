package com.ynov.tvshows.show_details.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ynov.tvshows.show_details.presentation.components.ShowDetailsScreen
import com.ynov.tvshows.ui.theme.TvShowsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra("showId", -1)
        enableEdgeToEdge()
        setContent {
            TvShowsTheme {
                ShowDetailsScreen()
            }
        }
    }
}