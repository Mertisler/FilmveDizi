package com.loc.filmvedizi.data.tv.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.filmvedizi.data.Genre
import com.loc.filmvedizi.data.tv.model.TvShow
import com.loc.filmvedizi.data.tv.repository.TvRepository
import kotlinx.coroutines.launch

class TvViewModel(
    private val repository: TvRepository
): ViewModel() {

    var tvShows = mutableStateOf<List<TvShow>>(emptyList())
        private set

    var genres = mutableStateOf<List<Genre>>(emptyList())
        private set

    var selectedGenreId = mutableStateOf<Int?>(null)
        private set

    var searchQuery = mutableStateOf("")
        private set

    fun updateSearchQuery(query: String) {
        searchQuery.value = query
    }

    fun loadPopularTvShows() {
        viewModelScope.launch {
            tvShows.value = repository.getPopularTvShows().results
        }
    }

    fun loadGenres() {
        viewModelScope.launch {
            genres.value = repository.getGenres().genres
        }
    }

    fun selectGenre(genreId: Int) {
        selectedGenreId.value = genreId
        loadTvShowsByGenre(genreId)
    }

    fun clearSelectedGenre() {
        selectedGenreId.value = null
        loadPopularTvShows()
    }

    fun loadTvShowsByGenre(genreId: Int) {
        viewModelScope.launch {
            tvShows.value = repository.getTvShowsByGenre(genreId).results
        }
    }

    fun searchTvShows(query: String) {
        viewModelScope.launch {
            tvShows.value = repository.searchTvShows(query).results
        }
    }
}
