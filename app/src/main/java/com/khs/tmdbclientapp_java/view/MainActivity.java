package com.khs.tmdbclientapp_java.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.khs.tmdbclientapp_java.R;
import com.khs.tmdbclientapp_java.databinding.MainBinder;
import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.service.MovieAPIService;
import com.khs.tmdbclientapp_java.service.RetrofitInstance;
import com.khs.tmdbclientapp_java.viewmodel.MainViewModel;

import java.util.List;

/*
* Update
* ttt
* */

public class MainActivity extends AppCompatActivity {

    private MovieAPIService service;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("TMDB Popular Movie Today");
        init();
        getPopularMovies();
    }

    private void init() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    private void getPopularMovies() {
        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                Log.d("DEBUG",movies.toString());
            }
        });
    }
}
