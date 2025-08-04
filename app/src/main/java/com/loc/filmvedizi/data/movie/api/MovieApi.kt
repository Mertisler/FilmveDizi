package com.loc.filmvedizi.data.movie.api

import com.loc.filmvedizi.ApiConstants
import com.loc.filmvedizi.data.GenreResponse
import com.loc.filmvedizi.data.movie.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY
    ): MovieResponse


    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY,
        @Query("with_genres") genreId: Int
    ): MovieResponse

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY,
        @Query("query") query: String
    ): MovieResponse
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY
    ): GenreResponse

}