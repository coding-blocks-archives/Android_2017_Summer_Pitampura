package com.codingblocks.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    TextView tvSc0, tvSc1, tvSc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Pandora", "Arnav", "Java"));
        courses.add(new Course("Launchpad", "Prateek", "C++"));
        courses.add(new Course("Crux", "Sumeet", "Java"));


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        tvSc0 = (TextView) findViewById(R.id.tvStuCount0);
        tvSc1 = (TextView) findViewById(R.id.tvStuCount1);
        tvSc2 = (TextView) findViewById(R.id.tvStuCount2);

        final FragmentManager fragMan = getSupportFragmentManager();

        View.OnClickListener courseButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course course = null;
                int cid = 0;

                switch (view.getId()) {
                    case R.id.btn1: course = courses.get(0); cid = 0; break;
                    case R.id.btn2: course = courses.get(1); cid = 1; break;
                    case R.id.btn3: course = courses.get(2); cid = 2; break;
                }

                fragMan.beginTransaction()
                        .replace(R.id.fragContainer,
                                Course2Fragment.newInstance(course, cid))
                        .commit();
            }
        };

        btn1.setOnClickListener(courseButtonListener);
        btn2.setOnClickListener(courseButtonListener);
        btn3.setOnClickListener(courseButtonListener);

    }

    void addStudent(int cid) {
        switch (cid) {
            case 0:
                tvSc0.setText(String.valueOf(
                        Integer.valueOf(tvSc0.getText().toString()) + 1
                ));

                break;
            case 1:
                tvSc1.setText(String.valueOf(
                        Integer.valueOf(tvSc1.getText().toString()) + 1
                ));
                break;
            case 2:
                tvSc2.setText(String.valueOf(
                        Integer.valueOf(tvSc2.getText().toString()) + 1
                ));
                break;
        }
    }
}
