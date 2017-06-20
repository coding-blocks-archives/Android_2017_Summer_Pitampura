package com.codingblocks.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course2Fragment extends Fragment {

    public static final String ARG_NAME = "name";
    public static final String ARG_TEACHER = "teacher";
    public static final String ARG_LANGUAGE = "language";
    public static final String ARG_CID = "courseId";


    private String courseName = "Sample Course";
    private String courseTeacher = "Sample Teacher";
    private String courseLanguage = "Sample Language";
    private int courseId = 0;

    TextView tvName, tvTeacher, tvLang;
    Button btnAddStudent;

    public Course2Fragment() {
        // Required empty public constructor
    }


    public static Course2Fragment newInstance(Course c, int cId) {

        Course2Fragment fragment = new Course2Fragment();

        Bundle args = new Bundle();
        args.putString(ARG_LANGUAGE, c.getLanguage());
        args.putString(ARG_NAME, c.getName());
        args.putString(ARG_TEACHER, c.getTeacher());
        args.putInt(ARG_CID, cId);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            courseName = getArguments().getString(ARG_NAME);
            courseLanguage = getArguments().getString(ARG_LANGUAGE);
            courseTeacher = getArguments().getString(ARG_TEACHER);
            courseId = getArguments().getInt(ARG_CID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);

        tvName = (TextView) rootView.findViewById(R.id.tvCourseName);
        tvTeacher = (TextView) rootView.findViewById(R.id.tvCourseTeacher);
        tvLang = (TextView) rootView.findViewById(R.id.tvCourseLanguage);
        btnAddStudent = (Button) rootView.findViewById(R.id.btnAddStudent);

        tvName.setText(courseName);
        tvTeacher.setText(courseTeacher);
        tvLang.setText(courseLanguage);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // increment admissions[courseId] which is in MainActivity
                ((MainActivity) getActivity()).addStudent(courseId);
            }
        });

        return rootView;
    }

}
