package com.codingblocks.lists;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

/**
 * Created by rishabhkhanna on 13/06/17.
 */

public class StudentAdapter extends BaseAdapter {

    ArrayList<Student> studentArrayList;
    Context context;
    public static final String TAG = "StuddentAdapter";

    public StudentAdapter(ArrayList<Student> studentArrayList, Context context) {

        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: ");
        return studentArrayList.size();
    }

    @Override
    public Student getItem(int position) {
        return studentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: " + position);
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Student thisStudent = getItem(position);
        long startTime =  System.currentTimeMillis();

        Log.d(TAG, "getView: " + parent.getId());
        StudentViewHolder studentViewHolder = null;
        if (convertView == null) {

            convertView = li.inflate(R.layout.tupple_layout, parent,false);

            studentViewHolder = new StudentViewHolder();
            studentViewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            studentViewHolder.tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
            convertView.setTag(studentViewHolder);

        }else {
            studentViewHolder = (StudentViewHolder) convertView.getTag();
        }




//        Log.d(TAG, "getView: " + position + " : " + convertView);



        studentViewHolder.tvName.setText(thisStudent.getName());
        studentViewHolder.tvCourse.setText(thisStudent.getCourse());

        long stopTime = System.currentTimeMillis() - startTime;
//        Log.d(TAG, "getView: time taken " + stopTime);

        return convertView;
    }
    static class StudentViewHolder{
        TextView tvName;
        TextView tvCourse;
    }

}
