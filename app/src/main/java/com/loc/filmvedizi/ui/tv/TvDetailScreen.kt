package com.loc.filmvedizi.ui.tv

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.loc.filmvedizi.ApiConstants
import com.loc.filmvedizi.data.movie.model.Movie
import com.loc.filmvedizi.data.tv.model.TvShow

@Composable
fun TvDetailScreen(tvShow: TvShow) {
    Column(modifier = Modifier.padding(16.dp)) {
        tvShow.posterPath?.let {
            Image(
                painter = rememberAsyncImagePainter(ApiConstants.IMAGE_BASE_URL + it),
                contentDescription = tvShow.name,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
        }
        Text(tvShow.name, style = MaterialTheme.typography.titleMedium)
        Text(tvShow.firstAirDate ?: "Tarih yok", style = MaterialTheme.typography.bodyLarge)
        Text(tvShow.overview, style = MaterialTheme.typography.bodySmall)
    }
}
