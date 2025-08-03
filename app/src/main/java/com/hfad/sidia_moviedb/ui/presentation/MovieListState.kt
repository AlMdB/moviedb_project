package com.hfad.sidia_moviedb.ui.presentation

import com.hfad.sidia_moviedb.data.models.Movie

data class MovieListState (
    val isLoading: Boolean = false,
    val popularMovieListPage: Int =1 ,
    val isCurrentPopularScreen: Boolean = true,
    val popularMovieList: List<Movie> = emptyList()
)