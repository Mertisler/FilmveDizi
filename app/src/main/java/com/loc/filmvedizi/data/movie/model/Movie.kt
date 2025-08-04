package com.loc.filmvedizi.data.movie.model


data class MovieResponse(
    val results: List<Movie>
)

data class Movie(
    val id: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val voteAverage: Double,
    val releaseDate: String
)

