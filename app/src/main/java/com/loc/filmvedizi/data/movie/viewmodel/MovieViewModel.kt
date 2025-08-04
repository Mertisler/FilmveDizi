package com.loc.filmvedizi.data.movie.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.filmvedizi.data.Genre
import com.loc.filmvedizi.data.movie.model.Movie
import com.loc.filmvedizi.data.movie.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository
): ViewModel() {

    var movies = mutableStateOf<List<Movie>>(emptyList())
        private set

    var genres = mutableStateOf<List<Genre>>(emptyList())
        private set

    var selectedGenreId by mutableStateOf<Int?>(null)
        private set

    fun loadPopularMovies() {
        viewModelScope.launch {
            movies.value = repository.getPopularMovies().results
        }
    }

    fun loadMoviesByGenre(genreId: Int) {
        viewModelScope.launch {
            movies.value = repository.getMoviesByGenre(genreId).results
        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch {
            movies.value = repository.searchMovies(query).results
        }
    }

    fun loadGenres() {
        viewModelScope.launch {
            genres.value = repository.getGenres().genres
        }
    }

    fun selectGenre(genreId: Int) {
        selectedGenreId = genreId
        loadMoviesByGenre(genreId)
    }

    fun clearSelectedGenre() {
        selectedGenreId = null
        loadPopularMovies()
    }
}