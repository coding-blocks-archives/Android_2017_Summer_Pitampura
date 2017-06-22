package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rishabhkhanna on 15/06/17.
 */

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>{
    public static final String TAG = "StudentRecyclerAdapter";

    ArrayList<Student> studentArrayList;
    Context context;

    @Override
    public int getItemViewType(int position) {
        Student thisStudent = studentArrayList.get(position);
        if (thisStudent.getCourse().length() > 10){
            return 0;
        }
        return 1;
    }

    public StudentRecyclerAdapter(ArrayList<Student> studentArrayList, Context context) {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutType;
        if(viewType == 0){
            layoutType = R.layout.student_layout;
        }else{
            layoutType = R.layout.student_layout_right;
        }
//        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(layoutType
                ,parent,false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(itemView);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        Student thisStudent = studentArrayList.get(position);
        holder.tvName.setText(thisStudent.getName());
        holder.tvCourse.setText(thisStudent.getCourse());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvCourse;
        View itemView;
        public StudentViewHolder(View itemView) {
            super(itemView);
//            Log.d(TAG, "StudentViewHolder: ");
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);
            this.itemView = itemView;
        }
    }
}
