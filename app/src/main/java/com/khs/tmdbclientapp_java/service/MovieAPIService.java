package com.khs.tmdbclientapp_java.service;

import com.khs.tmdbclientapp_java.model.MovieDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @auther hyeoksin
 * @since
 */
public interface MovieAPIService {
    @GET("movie/popular")
    Call<MovieDBResponse> getPopularMovies(@Query("api_key") String api_key, @Query("language") String language);
}
