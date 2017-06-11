package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    String[] cbCourses = {
//            "Pandora", "Elixir", "Crux", "Launchpad"
//    };
    ArrayList<Course> cbCourses = generateCourses();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView courseListView = (ListView) findViewById(R.id.lv_courses);

//        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                cbCourses
//        );

//        courseListView.setAdapter(courseAdapter);

        CourseAdapter courseAdapter = new CourseAdapter();
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

    class CourseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return cbCourses.size();
        }

        @Override
        public Course getItem(int i) {
            return cbCourses.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater li = getLayoutInflater();

            Course thisCourse = getItem(i);

            View itemView = li.inflate(R.layout.list_item_course, null);

            ((TextView)itemView.findViewById(R.id.tv_courseName))
                    .setText(thisCourse.getName());
            ((TextView)itemView.findViewById(R.id.tv_centerName))
                    .setText(thisCourse.getCenter());
            ((TextView)itemView.findViewById(R.id.tv_courseBatches))
                    .setText(String.valueOf(thisCourse.getBatches()));
            ((TextView)itemView.findViewById(R.id.tv_teacherName))
                    .setText(String.valueOf(thisCourse.getTeacher()));


            return itemView;
        }
    }
}
