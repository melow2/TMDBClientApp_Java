package com.khs.tmdbclientapp_java.view.handler;

/**
 * @auther hyeoksin
 * @since
 */
public interface itemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);
    void onItemSwiped(int position);
}
