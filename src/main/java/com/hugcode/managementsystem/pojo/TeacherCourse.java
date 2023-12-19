package com.hugcode.managementsystem.pojo;

public class TeacherCourse extends Course {
    private Double avgGrade;
    private Double maxGrade;
    private Double minGrade;

    @Override
    public String toString() {
        return "TeacherCourse{" +
                "avgGrade=" + avgGrade +
                ", maxGrade=" + maxGrade +
                ", minGrade=" + minGrade +
                '}';
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public Double getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(Double maxGrade) {
        this.maxGrade = maxGrade;
    }

    public Double getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(Double minGrade) {
        this.minGrade = minGrade;
    }
}
