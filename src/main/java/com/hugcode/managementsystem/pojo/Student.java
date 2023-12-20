package com.hugcode.managementsystem.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Student {

    private String sid;
    private String sname;

    private String ssex;
    private Integer sage;

    private String password;

    private List<Course> courses;
    private Double totalCredits;
    private Double completedCredits;

    public Student() {}
    public Student(String sid, String sname, String ssex, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
    }


    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                ", totalCredits=" + totalCredits +
                ", completedCredits=" + completedCredits +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
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

    public Double getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(Double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public Double getCompletedCredits() {
        return completedCredits;
    }

    public void setCompletedCredits(Double completedCredits) {
        this.completedCredits = completedCredits;
    }
}
