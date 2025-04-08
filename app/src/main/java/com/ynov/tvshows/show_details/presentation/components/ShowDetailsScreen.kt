package com.ynov.tvshows.show_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.ynov.tvshows.show_details.presentation.ShowDetailsViewModel
import com.ynov.tvshows.ui.theme.Pink40
import com.ynov.tvshows.ui.theme.PurpleGrey40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDetailsScreen(
    showDetailsViewModel: ShowDetailsViewModel = hiltViewModel()
) {
    val showDetailsState by showDetailsViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        showDetailsViewModel.getShowDetails()
    }

    Scaffold(
        containerColor = Pink40,
        modifier = Modifier.fillMaxSize(),
        /*TopBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PurpleGrey40,
                ),
                title = {
                    Text(
                        text = "Arrow",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif
                    )
                },
            )
        }*/
    ) { innerPadding ->

        when {
            showDetailsState.isLoading -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    CircularProgressIndicator()
                }
            }

            showDetailsState.error != null -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    Text(
                        text = showDetailsState.error ?: "Unknown error",
                        color = Color.Red,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            else -> {
                showDetailsState.showDetails?.let { ShowDetailsItem(showDetails = it) }
            }
        }

    }
    }
