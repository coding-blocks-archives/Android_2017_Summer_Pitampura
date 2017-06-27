package com.codingblocks.restapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by championswimmer on 27/06/17.
 */

public class PostsAdapter
        extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private ArrayList<Post> postList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener {
        void onItemClicked(int pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PostsAdapter(ArrayList<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    void updatePostList(ArrayList<Post> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE
                );
        View itemView = li.inflate(R.layout.list_item_post, parent, false);

        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, final int position) {
        final Post thisPost = postList.get(position);

        holder.tvTitle.setText(thisPost.getTitle());
        holder.tvBody.setText(thisPost.getBody());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClicked(thisPost.getId());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvBody;
        View rootView;
        public PostViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody);
            rootView = itemView;
        }
    }

}
