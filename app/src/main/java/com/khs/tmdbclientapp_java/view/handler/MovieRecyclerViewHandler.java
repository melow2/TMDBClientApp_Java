package com.khs.tmdbclientapp_java.view.handler;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.khs.tmdbclientapp_java.R;
import com.khs.tmdbclientapp_java.model.Movie;
import com.khs.tmdbclientapp_java.view.adapter.MovieAdapter;

/**
 * @auther hyeoksin
 * @since
 */
public class MovieRecyclerViewHandler extends ItemTouchHelper.Callback {

    private final Context mContext;
    private final itemTouchHelperAdapter mAdapter;

    public MovieRecyclerViewHandler(Context context, itemTouchHelperAdapter adapter){
        this.mContext = context;
        this.mAdapter = adapter;
    }

    public void onItemClicked(View view, Movie item){

    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        // 어떠한 방향으로 드래그 혹은 스와이프 되었는지 알려준다.
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN| ItemTouchHelper.START | ItemTouchHelper.END;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemSwiped(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
    }
}
