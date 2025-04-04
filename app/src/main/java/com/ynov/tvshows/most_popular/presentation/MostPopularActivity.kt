package com.ynov.tvshows.most_popular.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ynov.tvshows.most_popular.presentation.components.MostPopularScreen
import com.ynov.tvshows.ui.theme.TvShowsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostPopularActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TvShowsTheme {
                MostPopularScreen()
            }
        }
    }
}