package com.codingblocks.recyclerview;

/**
 * Created by rishabhkhanna on 15/06/17.
 */

public class Student {
    String name;
    String Course;

    public Student(String name, String course) {
        this.name = name;
        Course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
