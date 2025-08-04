package com.loc.filmvedizi.data.tv.model

import com.google.gson.annotations.SerializedName

data class TvShow(

    val id: Int,
    val name: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("first_air_date") val firstAirDate: String?


)
data class TvResponse(
    val results: List<TvShow>
)
