package com.hfad.sidia_moviedb.movieDetails

import com.hfad.sidia_moviedb.data.models.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)