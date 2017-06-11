package com.codingblocks.listviews;

/**
 * Created by championswimmer on 11/06/17.
 */

public class Course {
    String name;
    String teacher;
    Integer batches;
    String center;

    public Course(String name, String teacher, Integer batches, String center) {
        this.name = name;
        this.teacher = teacher;
        this.batches = batches;
        this.center = center;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public Integer getBatches() {
        return batches;
    }

    public String getCenter() {
        return center;
    }
}
