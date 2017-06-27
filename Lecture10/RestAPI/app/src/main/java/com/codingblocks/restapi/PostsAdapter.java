package com.codingblocks.restapi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by championswimmer on 27/06/17.
 */

public class PostsAdapter
        extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        public PostViewHolder(View itemView) {
            super(itemView);
        }
    }

}
