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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Course2Fragment cFrag = Course2Fragment.newInstance(
//                        "Pandora",
//                        "Arnav",
//                        "Java"
//                );

                fragMan.beginTransaction()
                        .replace(R.id.fragContainer, new Course2Fragment())
                        .commit();

            }
        });

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                c1Frag.setData(
//                        "Pandora",
//                        "Arnav",
//                        "Java"
//                );
//            }
//        });


    }
}
