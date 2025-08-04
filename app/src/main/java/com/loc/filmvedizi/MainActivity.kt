package com.loc.filmvedizi


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.loc.filmvedizi.data.movie.repository.MovieRepository
import com.loc.filmvedizi.data.movie.viewmodel.MovieViewModel
import com.loc.filmvedizi.data.tv.repository.TvRepository
import com.loc.filmvedizi.data.tv.viewmodel.TvViewModel
import com.loc.filmvedizi.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var tvViewModel: TvViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val movieApi = RetrofitInstance.movieApi
        val tvApi = RetrofitInstance.tvApi

        val movieRepo = MovieRepository(movieApi)
        val tvRepo = TvRepository(tvApi)

        val movieFactory = MovieViewModelFactory(movieRepo)
        val tvFactory = TvViewModelFactory(tvRepo)


        movieViewModel = ViewModelProvider(this, movieFactory)
            .get(MovieViewModel::class.java)
        tvViewModel = ViewModelProvider(this, tvFactory)
            .get(TvViewModel::class.java)

        setContent {

            movieViewModel.loadPopularMovies()
            tvViewModel.loadPopularTvShows()

            AppNavGraph(movieViewModel, tvViewModel)
        }
    }
}


