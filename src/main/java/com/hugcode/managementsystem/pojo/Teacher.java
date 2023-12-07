package com.hugcode.managementsystem.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Teacher {
    private String tid;
    private String tname;
    private Double tsalary;
    private String title;
    @JsonIgnore
    private String password;
    private List<Course>courses;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tsalary=" + tsalary +
                ", title='" + title + '\'' +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Double getTsalary() {
        return tsalary;
    }

    public void setTsalary(Double tsalary) {
        this.tsalary = tsalary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
