package com.khs.tmdbclientapp_java.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.repository.MovieRepository;

import java.util.List;

/**
 * @auther hyeoksin
 * @since
 */

public class MainViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
    }

    public LiveData<List<Movie>> getAllMovies(){
        return movieRepository.getMutableLiveData();
    }

}
