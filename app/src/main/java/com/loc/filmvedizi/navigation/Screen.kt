package com.loc.filmvedizi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.loc.filmvedizi.data.movie.viewmodel.MovieViewModel
import com.loc.filmvedizi.data.tv.viewmodel.TvViewModel
import com.loc.filmvedizi.ui.movie.MovieDetailScreen
import com.loc.filmvedizi.ui.movie.MovieHomeScreen
import com.loc.filmvedizi.ui.tv.TvDetailScreen
import com.loc.filmvedizi.ui.tv.TvHomeScreen

sealed class Screen(val route: String) {
    object MovieHome : Screen("movie_home")
    object MovieDetail : Screen("movie_detail/{movieId}") {
        fun createRoute(id: Long) = "movie_detail/$id"
    }
    object TvHome : Screen("tv_home")
    object TvDetail : Screen("tv_detail/{tvId}") {
        fun createRoute(id: Int) = "tv_detail/$id"
    }
}

@Composable
fun AppNavGraph(
    movieViewModel: MovieViewModel,
    tvViewModel: TvViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Screen.TvHome.route) {
        composable(Screen.TvHome.route) {
            TvHomeScreen(tvViewModel) { tvShow ->
                navController.navigate(Screen.TvDetail.createRoute(tvShow.id))
            }
        }
        composable(Screen.TvDetail.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("tvId")?.toIntOrNull()
            val tvShow = tvViewModel.tvShows.value.find { it.id == id }
            tvShow?.let { TvDetailScreen(it) }
        }

        composable(Screen.MovieHome.route) {
            MovieHomeScreen(movieViewModel) { movie ->
                navController.navigate(Screen.MovieDetail.createRoute(movie.id))
            }
        }
        composable(Screen.MovieDetail.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("movieId")?.toIntOrNull()
            val movie = movieViewModel.movies.value.find { it.id.toInt() == id }
            movie?.let { MovieDetailScreen(it) }
        }
    }
}
