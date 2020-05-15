package com.khs.tmdbclientapp_java.view.adapter;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.khs.tmdbclientapp_java.R;
import com.khs.tmdbclientapp_java.databinding.MovieBinder;
import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.view.holder.MovieViewHolder;

/**
 * @auther hyeoksin
 * @since
 */
public class MovieAdapter extends ListAdapter<Movie,MovieViewHolder>{

    Context context;
    private MovieBinder movieBinder;

    public  MovieAdapter(Context context) {
        super(new MovieDiffUtil());
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        movieBinder = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_movie,
                parent,false);
        return new MovieViewHolder(context,movieBinder);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        movieBinder.setMovie(getItem(holder.getAdapterPosition()));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
