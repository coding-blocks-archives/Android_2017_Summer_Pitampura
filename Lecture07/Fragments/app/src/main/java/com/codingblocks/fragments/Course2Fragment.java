package com.codingblocks.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    private String courseName = "Sample Course";
    private String courseTeacher = "Sample Teacher";
    private String courseLanguage = "Sample Language";

    TextView tvName, tvTeacher, tvLang;

    public Course2Fragment() {
        // Required empty public constructor
    }

    /**
     *
     * @param name
     * @param teacher
     * @param language
     * @return
     */
    public static Course2Fragment newInstance(String name,
                                              String teacher, String language) {

        Course2Fragment fragment = new Course2Fragment();

        Bundle args = new Bundle();
        args.putString(ARG_LANGUAGE, language);
        args.putString(ARG_NAME, name);
        args.putString(ARG_TEACHER, teacher);

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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);

        tvName = (TextView) rootView.findViewById(R.id.tvCourseName);
        tvTeacher = (TextView) rootView.findViewById(R.id.tvCourseTeacher);
        tvLang = (TextView) rootView.findViewById(R.id.tvCourseLanguage);

        tvName.setText(courseName);
        tvTeacher.setText(courseTeacher);
        tvLang.setText(courseLanguage);

        return rootView;
    }

}
