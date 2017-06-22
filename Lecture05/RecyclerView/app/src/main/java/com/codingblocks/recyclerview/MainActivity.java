package com.codingblocks.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList;
    RecyclerView recyclerView;
    EditText etName;
    EditText etCourse;
    Button btnAdd;
    StudentRecyclerAdapter studentRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout_student);
        studentArrayList = generateStudents();
        recyclerView = (RecyclerView) findViewById(R.id.rvStudent);
        etName = (EditText) findViewById(R.id.etName);
        etCourse = (EditText) findViewById(R.id.etCourse);

        studentRecyclerAdapter = new StudentRecyclerAdapter(studentArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentRecyclerAdapter);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addStudent();
            }
        });

    }

    public void addStudent(){
        studentArrayList = getNewStudents();
//        String name = etName.getText().toString();
//        String course = etCourse.getText().toString();


//        studentArrayList.add(new Student(name,course));
        studentRecyclerAdapter.notifyDataSetChanged();
//        etName.setText("");
//        etCourse.setText("");

    }


    static ArrayList<Student> generateStudents(){
        ArrayList<Student> newStudents = new ArrayList<>();
        newStudents.add(new Student("Rishabh","Pandora"));
        return newStudents;

    }
    static ArrayList<Student> getNewStudents(){
        ArrayList<Student> newStudents = new ArrayList<>();
        newStudents.add(new Student("Rishabh","Pandora"));
        newStudents.add(new Student("Rishabh","Pandora"));
        newStudents.add(new Student("Rishabh","Pandora"));
        newStudents.add(new Student("Rishabh","Pandora"));
        newStudents.add(new Student("Rishabh","Pandora"));
        newStudents.add(new Student("Rishabh","Pandora"));
        newStudents.add(new Student("Rishabh","Pandora"));
        newStudents.add(new Student("Rishabh","Pandora"));
        return newStudents;

    }
}
