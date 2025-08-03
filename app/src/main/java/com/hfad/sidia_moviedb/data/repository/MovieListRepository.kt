package com.hfad.sidia_moviedb.data.repository

import com.hfad.sidia_moviedb.data.models.Movie
import kotlinx.coroutines.flow.Flow
import com.hfad.sidia_moviedb.utils.Resource

interface MovieListRepository {

    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ) :Flow<Resource<List<Movie>>>

    suspend fun getMovie(id:Int):Flow<Resource<Movie>>
}