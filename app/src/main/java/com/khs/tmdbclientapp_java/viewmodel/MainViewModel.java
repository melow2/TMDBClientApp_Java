package com.khs.tmdbclientapp_java.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther hyeoksin
 * @since
 */

public class MainViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;
    private MutableLiveData<List<Movie>> mMovies;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
        mMovies = movieRepository.getMutableLiveData();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return mMovies;
    }

    public void deleteItem(Movie item){
        List<Movie> list = mMovies.getValue();
        list.remove(item);
        mMovies.setValue(list);
    }

    public void addItem(Movie item,int position){
        mMovies.getValue().add(position,item);
    }
}
