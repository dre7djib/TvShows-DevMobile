package com.ynov.tvshows.show_details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynov.tvshows.show_details.domain.model.ShowDetailsResponse
import com.ynov.tvshows.ui.theme.PurpleGrey40

@Composable
fun ShowDetailsItem(
    showDetails: ShowDetailsResponse
){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = PurpleGrey40
        )
    ){
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(5.dp)
        ){
            Text(
                text = showDetails.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)


        }
    }
}

