package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.models.Comment;

import java.util.ArrayList;

/**
 * Created by championswimmer on 29/06/17.
 */

public class CommentAdapter
        extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Context context;
    private ArrayList<Comment> comments;

    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_comment, parent, false);

        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {

        Comment thisComment = comments.get(position);

        holder.tvCommentBody.setText(thisComment.getBody());
        holder.tvCommentName.setText(thisComment.getName());
        holder.tvCommentEmail.setText(thisComment.getEmail());

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView tvCommentBody, tvCommentName, tvCommentEmail;

        public CommentViewHolder(View itemView) {
            super(itemView);

            tvCommentBody = (TextView) itemView.findViewById(R.id.tvCommentBody);
            tvCommentName = (TextView) itemView.findViewById(R.id.tvCommentName);
            tvCommentEmail = (TextView) itemView.findViewById(R.id.tvCommentEmail);
        }
    }
}
