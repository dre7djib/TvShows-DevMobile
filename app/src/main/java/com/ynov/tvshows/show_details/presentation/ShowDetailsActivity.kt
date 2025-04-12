package com.ynov.tvshows.show_details.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.ynov.tvshows.show_details.presentation.components.ShowDetailsScreen
import com.ynov.tvshows.ui.theme.TvShowsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowDetailsActivity : ComponentActivity() {
    private val viewModel: ShowDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val showId = intent.getStringExtra("showId")
        Log.d("showId", "showId from details activity: $showId")

        enableEdgeToEdge()

        viewModel.getShowDetails(showId ?: "")

        setContent {
            TvShowsTheme {
                val state = viewModel.state.collectAsState()
                ShowDetailsScreen(state.value)
            }
        }
    }
}