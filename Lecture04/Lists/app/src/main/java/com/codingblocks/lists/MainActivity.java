package com.codingblocks.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Student> studentArrayList = null;
    ListView listView;
    RecyclerView recyclerView;
    EditText etName;
    EditText etCourse;
    Button btnAdd;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentArrayList  = generateStudents();
        listView = (ListView) findViewById(R.id.lvStudent);
        Log.d(TAG, "onCreate: "  + R.id.lvStudent);
        final StudentAdapter studentAdapter = new StudentAdapter(studentArrayList,this);
//        recyclerView = (RecyclerView) findViewById(R.id.rvStudent);
//        final RecyclerAdapter studentAdapter = new RecyclerAdapter(studentArrayList,this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(studentAdapter);
        etName = (EditText) findViewById(R.id.etName);
        etCourse = (EditText) findViewById(R.id.etCourse);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        listView.setAdapter(studentAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String course = etCourse.getText().toString();

                studentArrayList.add(new Student(name,course));
                studentAdapter.notifyDataSetChanged();
            }
        });


    }


    public static ArrayList<Student> generateStudents(){
        ArrayList<Student> newStudents = new ArrayList<>();

        newStudents.add(new Student("A","Pandora"));
        Integer a = new Integer(10);
        Integer b = new Integer(10);
        b = a;


        return newStudents;

    }

}
