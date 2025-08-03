package com.hfad.sidia_moviedb.data.mappers

import com.hfad.sidia_moviedb.data.api.MovieDbApi
import com.hfad.sidia_moviedb.data.api.response.MovieDTO
import com.hfad.sidia_moviedb.data.models.Movie

fun MovieDTO.toMovie(category: String): Movie {
    val posterUrl = if (!this.poster_path.isNullOrEmpty()) {
        "${MovieDbApi.IMAGE_URL}w500${this.poster_path}"
    } else ""

    val backdropUrl = if (!this.backdrop_path.isNullOrEmpty()) {
        "${MovieDbApi.IMAGE_URL}w780${this.backdrop_path}"
    } else ""

    android.util.Log.d("MovieMapper", "Poster URL: $posterUrl")
    android.util.Log.d("MovieMapper", "Backdrop URL: $backdropUrl")

    return Movie(
        adult = this.adult ?: false,
        backdrop_path = backdropUrl,
        genre_ids = this.genre_ids ?: emptyList(),
        id = this.id ?: 0,
        original_language = this.original_language ?: "",
        original_title = this.original_title ?: "",
        overview = this.overview ?: "",
        popularity = this.popularity ?: 0.0,
        poster_path = posterUrl,
        release_date = this.release_date ?: "",
        title = this.title ?: "",
        video = this.video ?: false,
        vote_average = this.vote_average ?: 0.0,
        vote_count = this.vote_count ?: 0,
        category = category
    )
}