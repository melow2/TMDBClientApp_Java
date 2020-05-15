package com.khs.tmdbclientapp_java.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.khs.tmdbclientapp_java.R;
import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.model.MovieDBResponse;
import com.khs.tmdbclientapp_java.service.MovieAPIService;
import com.khs.tmdbclientapp_java.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @auther hyeoksin
 * @since
 */
public class MovieRepository {

    private Application application;
    private MovieAPIService service;
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();

    public MovieRepository(Application application){
        this.application = application;
        this.service = RetrofitInstance.getInstance();
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        Call<MovieDBResponse> callback = service.getPopularMovies(
                application.getApplicationContext().getString(R.string.api_key),
                application.getApplicationContext().getString(R.string.language));

        callback.enqueue(new Callback<MovieDBResponse>(){
            @Override
            public void onResponse(Call<MovieDBResponse> call, Response<MovieDBResponse> response) {
                MovieDBResponse movieDBResponse = response.body();
                if(movieDBResponse!=null && movieDBResponse.getMovies()!=null){
                    ArrayList<Movie> movies = (ArrayList<Movie>)movieDBResponse.getMovies();
                    mutableLiveData.setValue(movies);
                }
            }
            @Override
            public void onFailure(Call<MovieDBResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
