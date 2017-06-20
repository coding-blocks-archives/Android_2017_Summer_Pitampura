package com.codingblocks.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {

    TextView tvName, tvTeacher, tvLang;

    public CourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);

        tvName = (TextView) rootView.findViewById(R.id.tvCourseName);
        tvTeacher = (TextView) rootView.findViewById(R.id.tvCourseTeacher);
        tvLang = (TextView) rootView.findViewById(R.id.tvCourseLanguage);

        return rootView;
    }

    public void setData (String courseName, String courseTeacher, String courseLanguage) {
        tvName.setText(courseName);
        tvTeacher.setText(courseTeacher);
        tvLang.setText(courseLanguage);
    }

}
