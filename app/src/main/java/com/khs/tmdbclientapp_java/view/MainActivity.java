package com.khs.tmdbclientapp_java.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.util.Log;

import com.khs.tmdbclientapp_java.R;
import com.khs.tmdbclientapp_java.databinding.MainBinder;
import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.service.MovieAPIService;
import com.khs.tmdbclientapp_java.service.RetrofitInstance;
import com.khs.tmdbclientapp_java.view.adapter.MovieAdapter;
import com.khs.tmdbclientapp_java.view.handler.MovieRecyclerViewHandler;
import com.khs.tmdbclientapp_java.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

/*
* Update
* ttt
* */

public class MainActivity extends AppCompatActivity {

    private MovieAPIService service;
    private MainViewModel viewModel;

    private MainBinder binding;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    private ItemTouchHelper mItemTouchHelper;
    private MovieRecyclerViewHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("TMDB Popular Movie Today");
        init();
        getPopularMovies();
    }

    private void init() {
        // #1 ViewModel
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // #2 Set Binding & RecyclerView
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        recyclerView = binding.rvMovies;
        adapter = new MovieAdapter(this,viewModel);
        mHandler = new MovieRecyclerViewHandler(this,adapter);
        mItemTouchHelper = new ItemTouchHelper(mHandler);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
    }

    private void getPopularMovies() {
        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                Log.d("DEBUG","onChanged: "+movies.size());
                setRecyclerView();
                adapter.submitList(movies != null ? new ArrayList<>(movies) : null);
            }
        });
    }

    private void setRecyclerView() {
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        }
    }
}
