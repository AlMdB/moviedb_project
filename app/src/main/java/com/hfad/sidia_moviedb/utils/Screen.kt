package com.hfad.sidia_moviedb.utils

sealed class Screen(val route: String){
    object Home : Screen("main")
    object Details : Screen("details")
    object PopularMovieList: Screen("popularMovies")
}