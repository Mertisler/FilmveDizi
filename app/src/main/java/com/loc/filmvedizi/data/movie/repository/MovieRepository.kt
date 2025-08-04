package com.loc.filmvedizi.data.movie.repository

import com.loc.filmvedizi.data.GenreResponse
import com.loc.filmvedizi.data.movie.api.MovieApi
import com.loc.filmvedizi.data.movie.model.MovieResponse

class MovieRepository(private val api: MovieApi) {
    suspend fun getPopularMovies(): MovieResponse {
        return api.getPopularMovies()
    }
    suspend fun getMoviesByGenre(genreId: Int): MovieResponse = api.getMoviesByGenre(genreId = genreId)
    suspend fun searchMovies(query: String): MovieResponse = api.searchMovies(query = query)
    suspend fun getGenres(): GenreResponse = api.getGenres()
}
