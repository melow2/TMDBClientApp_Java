package com.khs.tmdbclientapp_java.view.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @auther hyeoksin
 * @since
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    public BaseViewHolder(@NonNull Context context, @NonNull View itemView) {
        super(itemView);
        this.context = context;
    }

    abstract void bindDataToViewHolder();
}
