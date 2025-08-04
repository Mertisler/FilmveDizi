package com.loc.filmvedizi


import com.loc.filmvedizi.ApiConstants
import com.loc.filmvedizi.data.movie.api.MovieApi
import com.loc.filmvedizi.data.tv.api.TvApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieApi: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }

    val tvApi: TvApi by lazy {
        retrofit.create(TvApi::class.java)
    }
}
