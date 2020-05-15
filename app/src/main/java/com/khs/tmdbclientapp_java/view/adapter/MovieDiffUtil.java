package com.khs.tmdbclientapp_java.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.khs.tmdbclientapp_java.model.Movie;

/**
 * @auther hyeoksin
 * @since
 */
public class MovieDiffUtil extends DiffUtil.ItemCallback<Movie> {

    @Override
    public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getOriginalTitle() == newItem.getOriginalTitle();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getVoteAverage().equals(newItem.getVoteAverage());
    }
}
