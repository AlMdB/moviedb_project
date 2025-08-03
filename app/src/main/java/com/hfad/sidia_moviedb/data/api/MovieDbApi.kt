package com.hfad.sidia_moviedb.data.api

import com.hfad.sidia_moviedb.BuildConfig
import com.hfad.sidia_moviedb.data.api.response.MovieListDTO
import com.hfad.sidia_moviedb.data.api.response.MovieDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbApi {


    @GET("movie/{category}")
    suspend fun getMoviesList(
        @Path("category") category: String,
        @Query("page") page:Int,
        @Query("api_key") api_key: String = BuildConfig.TMDB_API_KEY

    ):MovieListDTO

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String = BuildConfig.TMDB_API_KEY
    ):MovieDTO

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/"
    }
}