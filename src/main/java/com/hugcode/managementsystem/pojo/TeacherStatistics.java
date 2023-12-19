package com.hugcode.managementsystem.pojo;

public class TeacherStatistics {
    private String title;
    private Integer count;
    private Double avgSalary;

    @Override
    public String toString() {
        return "TeacherStatistics{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", avgSalary=" + avgSalary +
                '}';
    }

    public TeacherStatistics(String title, Integer count, Double avgSalary) {
        this.title = title;
        this.count = count;
        this.avgSalary = avgSalary;
    }

    public TeacherStatistics() {
    }

    public String getTitle() {
        return title;
    }

    public Integer getCount() {
        return count;
    }

    public Double getAvgSalary() {
        return avgSalary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setAvgSalary(Double avgSalary) {
        this.avgSalary = avgSalary;
    }
}
