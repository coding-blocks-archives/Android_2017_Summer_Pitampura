package com.codingblocks.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Pandora", "Arnav", "Java"));
        courses.add(new Course("Launchpad", "Prateek", "C++"));
        courses.add(new Course("Crux", "Sumeet", "Java"));

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        final FragmentManager fragMan = getSupportFragmentManager();
        final CourseFragment c1Frag = new CourseFragment();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragMan.beginTransaction()
                        .replace(R.id.fragContainer, c1Frag)
                        .commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                c1Frag.setData(
                        "Pandora",
                        "Arnav",
                        "Java"
                );
            }
        });


    }
}
