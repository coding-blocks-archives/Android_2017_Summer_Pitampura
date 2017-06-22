package com.codingblocks.lists;

/**
 * Created by rishabhkhanna on 13/06/17.
 */

public class Student {
    String name;
    String course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student(String name, String course) {

        this.name = name;
        this.course = course;
    }
}
