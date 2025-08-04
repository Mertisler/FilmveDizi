package com.loc.filmvedizi.data.tv.repository

import com.loc.filmvedizi.data.GenreResponse
import com.loc.filmvedizi.data.tv.model.TvResponse
import com.loc.filmvedizi.data.tv.api.TvApi

class TvRepository(private val api: TvApi) {
    suspend fun getPopularTvShows(): TvResponse = api.getPopularTvShows()
    suspend fun getTvShowsByGenre(genreId: Int): TvResponse = api.getTvShowsByGenre(genreId = genreId)
    suspend fun searchTvShows(query: String): TvResponse = api.searchTvShows(query = query)
    suspend fun getGenres(): GenreResponse = api.getGenres()

}