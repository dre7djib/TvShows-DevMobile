package com.ynov.tvshows.most_popular.presentation.components


import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ynov.tvshows.most_popular.domain.model.TvShow
import com.ynov.tvshows.show_details.presentation.ShowDetailsActivity
import com.ynov.tvshows.ui.theme.PurpleGrey40

@Composable
fun MostPopularItem(
    tvShow: TvShow
) {
    val context = LocalContext.current

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                val intent = Intent(context, ShowDetailsActivity::class.java)
                intent.putExtra("showId", tvShow.id);
                context.startActivity(intent)
            },
        colors = CardDefaults.cardColors(
            containerColor = PurpleGrey40
        )
    ){
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(5.dp)
        ) {
            Text(
                text = tvShow.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            ) {
                AsyncImage(
                    contentDescription = null,
                    model = tvShow.image_thumbnail_path,
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = tvShow.permalink,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White)

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
private fun MostPopularItemPreview() {
    //EverythingItem()
}