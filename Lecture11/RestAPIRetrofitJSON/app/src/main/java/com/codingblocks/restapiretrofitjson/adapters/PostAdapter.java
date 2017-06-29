package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.models.Post;

import java.util.ArrayList;

/**
 * Created by championswimmer on 29/06/17.
 */

public class PostAdapter
        extends RecyclerView.Adapter <PostAdapter.PostViewHolder> {

    public static final String TAG = "PADPTR";

    private Context context;
    private ArrayList<Post> posts;


    public PostAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    public void updatePosts (ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_post, parent, false);

        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Post thisPost = posts.get(position);

        holder.tvPostTitle.setText(thisPost.getTitle());
        holder.tvPostBody.setText(thisPost.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvPostBody, tvPostTitle;

        public PostViewHolder(View itemView) {
            super(itemView);

            tvPostBody = (TextView) itemView.findViewById(R.id.tvPostBody);
            tvPostTitle = (TextView) itemView.findViewById(R.id.tvPostTitle);
        }
    }
}
