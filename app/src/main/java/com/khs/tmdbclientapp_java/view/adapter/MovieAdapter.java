package com.khs.tmdbclientapp_java.view.adapter;




import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.khs.tmdbclientapp_java.R;
import com.khs.tmdbclientapp_java.databinding.MovieBinder;
import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.view.MainActivity;
import com.khs.tmdbclientapp_java.view.handler.MovieRecyclerViewHandler;
import com.khs.tmdbclientapp_java.view.handler.itemTouchHelperAdapter;
import com.khs.tmdbclientapp_java.view.holder.MovieViewHolder;
import com.khs.tmdbclientapp_java.viewmodel.MainViewModel;

/**
 * @auther hyeoksin
 * @since
 */
public class MovieAdapter extends ListAdapter<Movie,MovieViewHolder> implements itemTouchHelperAdapter {

    private final Context mContext;
    private MovieBinder mMovieBinder;
    private final MainViewModel mViewModel;

    public  MovieAdapter(Context context,MainViewModel viewModel) {
        super(new MovieDiffUtil());
        this.mContext = context;
        this.mViewModel = viewModel;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mMovieBinder = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_movie,
                parent,false);
        return new MovieViewHolder(mContext,mMovieBinder);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        mMovieBinder.setMovie(getItem(holder.getAdapterPosition()));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Movie fromMovie = getItem(fromPosition);
    }

    @Override
    public void onItemSwiped(int position) {
        mViewModel.deleteItem(getItem(position));
    }
}
