package com.khs.tmdbclientapp_java.view.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.khs.tmdbclientapp_java.databinding.MovieBinder;

/**
 * @auther hyeoksin
 * @since
 */
public class MovieViewHolder extends BaseViewHolder {
    private MovieBinder movieBinder;

    public MovieViewHolder(@NonNull Context context, @NonNull MovieBinder movieBinder) {
        super(context, movieBinder.getRoot());
        this.movieBinder = movieBinder;
    }

    @Override
    void bindDataToViewHolder() {

    }
}
