package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] cbCourses = {
            "Pandora", "Elixir", "Crux", "Launchpad"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView courseListView = (ListView) findViewById(R.id.lv_courses);
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                cbCourses
        );
        courseListView.setAdapter(courseAdapter);
    }

    static ArrayList<Course> generateCourses () {
        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("Pandora", "Arnav", 1, "Pitampura"));
        courses.add(new Course("Elixir", "Arnav", 1, "Pitampura"));
        courses.add(new Course("Pandora", "Harshit", 1, "Dwarka"));
        courses.add(new Course("Elixir", "Aayush", 1, "Dwarka"));
        courses.add(new Course("Launchpad", "Prateek", 1, "Pitampura"));
        courses.add(new Course("Crux", "Sumeet", 3, "Pitampura"));
        courses.add(new Course("Algo++", "Prateek", 1, "Pitampura"));

        return courses;
    }
}
