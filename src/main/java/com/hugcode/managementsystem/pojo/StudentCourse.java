package com.hugcode.managementsystem.pojo;

import java.util.List;

public class StudentCourse extends Course {

    private Double grade;

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "grade=" + grade +
                '}';
    }
}
