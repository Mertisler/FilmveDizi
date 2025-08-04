package com.loc.filmvedizi.ui.movie

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

@Composable
fun MovieDetailScreen(movie: Movie) {
    Column(modifier = Modifier.padding(16.dp)) {
        movie.posterPath?.let {
            Image(
                painter = rememberAsyncImagePainter(ApiConstants.IMAGE_BASE_URL + it),
                contentDescription = movie.title,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
        }
        Text(movie.title, style = MaterialTheme.typography.titleMedium)
        Text(movie.releaseDate ?: "Tarih yok", style = MaterialTheme.typography.bodyLarge)
        Text(movie.overview, style = MaterialTheme.typography.bodySmall)
    }
}
