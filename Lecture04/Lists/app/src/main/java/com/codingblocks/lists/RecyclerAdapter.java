package com.codingblocks.lists;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by rishabhkhanna on 15/06/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewViewHolder> {
    
    public static final String TAG = "RecyclerView";
    
    private ArrayList<Student> studentArraylist;
    private Context context;

    public RecyclerAdapter(ArrayList<Student> studentArraylist, Context context) {
        this.studentArraylist = studentArraylist;
        this.context = context;
    }

    @Override
    public RecyclerviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        Log.d(TAG, "onCreateViewHolder: " + parent.getId());
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        View itemView = li.inflate(R.layout.tupple_layout,parent,false);
        
        return new RecyclerviewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerviewViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        Student thisStudent = studentArraylist.get(position);
        
        holder.tvName.setText(thisStudent.getName());
        holder.tvCourse.setText(thisStudent.getCourse());

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return studentArraylist.size();
    }

    static class RecyclerviewViewHolder extends RecyclerView.ViewHolder{
        
        TextView tvName;
        TextView tvCourse;

        public RecyclerviewViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "RecyclerviewViewHolder: ");
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);
        }
    }
}
