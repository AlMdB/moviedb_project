package com.hfad.sidia_moviedb.data.api.response

import com.google.gson.annotations.SerializedName

data class MovieListDTO(
    val page: Int,
    @SerializedName("results")  // Map "results" from API to "movieDTOS" in your code
    val movieDTOS: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)