package com.loc.filmvedizi.data.tv.api

import com.loc.filmvedizi.ApiConstants
import com.loc.filmvedizi.data.GenreResponse
import com.loc.filmvedizi.data.tv.model.TvResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApi {
    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY
    ): TvResponse

    @GET("genre/tv/list")
    suspend fun getTvGenres(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY
    ): GenreResponse

    @GET("discover/tv")
    suspend fun getTvShowsByGenre(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY,
        @Query("with_genres") genreId: Int
    ): TvResponse

    @GET("search/tv")
    suspend fun searchTvShows(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY,
        @Query("query") query: String
    ): TvResponse

    @GET("genre/tv/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String = ApiConstants.API_KEY
    ): GenreResponse
}
