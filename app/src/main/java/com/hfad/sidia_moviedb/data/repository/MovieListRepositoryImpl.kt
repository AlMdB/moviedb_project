package com.hfad.sidia_moviedb.data.repository

import coil.network.HttpException
import com.hfad.sidia_moviedb.data.models.Movie
import com.hfad.sidia_moviedb.utils.Resource
import com.hfad.sidia_moviedb.data.api.MovieDbApi
import com.hfad.sidia_moviedb.data.mappers.toMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieDbAPI: MovieDbApi
): MovieListRepository {

    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))

            val movieListFromAPI = try {
                movieDbAPI.getMoviesList(category, page)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Erro ao carregar api - sem conexão"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Erro ao carregar api http - ${e.response.code}"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Erro ao carregar filmes - ${e.message}"))
                return@flow
            }

            val movieList = movieListFromAPI.movieDTOS?.map { movieDto ->
                movieDto.toMovie(category)
            } ?: emptyList()

            emit(Resource.Success(movieList))
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))

            val movieFetched = try {
                movieDbAPI.getMovieDetails(id)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Erro ao carregar detalhes do filme"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Erro HTTP ao carregar detalhes"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Erro desconhecido ao carregar filme"))
                return@flow
            }

            emit(Resource.Success(movieFetched.toMovie("details")))
        }
    }
}