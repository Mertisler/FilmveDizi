package com.loc.filmvedizi.ui.movie

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.loc.filmvedizi.GenreChips
import com.loc.filmvedizi.data.movie.model.Movie
import com.loc.filmvedizi.data.movie.viewmodel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieHomeScreen(
    viewModel: MovieViewModel,
    onMovieClick: (Movie) -> Unit
) {
    val movies by viewModel.movies
    val genres by viewModel.genres
    val selectedGenreId = viewModel.selectedGenreId

    LaunchedEffect(Unit) {
        viewModel.loadGenres()
        viewModel.loadPopularMovies()
    }

    var query by remember { mutableStateOf("") }

    MovieSearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = {
            viewModel.searchMovies(it)
        }
    )


    GenreChips(
            genres = genres,
            selectedGenreId = selectedGenreId,
            onGenreSelected = { genreId ->
                if (genreId == null) viewModel.clearSelectedGenre()
                else viewModel.selectGenre(genreId)
            }
        )

        LazyColumn {
            items(movies) { movie ->
                MovieCard(movie = movie) {
                    onMovieClick(movie)
                }
            }
        }
    }

