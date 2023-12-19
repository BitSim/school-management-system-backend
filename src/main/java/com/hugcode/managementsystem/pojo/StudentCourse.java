package com.hugcode.managementsystem.pojo;


public class StudentCourse extends Course {

    private Double grade;
    private Integer status;

    @Override
    public String toString() {
        return "StudentCourse{" +
                "grade=" + grade +
                ", status=" + status +
                '}';
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
