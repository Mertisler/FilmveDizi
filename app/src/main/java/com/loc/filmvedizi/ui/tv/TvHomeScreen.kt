package com.loc.filmvedizi.ui.tv


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.loc.filmvedizi.GenreChips
import com.loc.filmvedizi.data.tv.model.TvShow
import com.loc.filmvedizi.data.tv.viewmodel.TvViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvHomeScreen(
    viewModel: TvViewModel,
    onTvClick: (TvShow) -> Unit
) {
    val tvShows by viewModel.tvShows
    val genres by viewModel.genres
    val selectedGenreId by viewModel.selectedGenreId
    val searchQuery by viewModel.searchQuery


    LaunchedEffect(Unit) {
        viewModel.loadGenres()
        viewModel.loadPopularTvShows()
    }

    Column {
        AppSearchBar(
            query = searchQuery,
            onQueryChange = { viewModel.updateSearchQuery(it) },
            onSearch = { viewModel.searchTvShows(it) }
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
            items(tvShows) { tv ->
                TvShowCard(tvShow = tv) {
                    onTvClick(tv)
                }
            }
        }
    }
}

