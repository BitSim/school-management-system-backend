package com.hugcode.managementsystem.pojo;

import java.util.HashMap;

public class CourseStatistics extends Course{
    private Double average_grade;
    private Double max_grade;
    private Double min_grade;
    public static HashMap<String,Double>getCreditMap(Double totalCredits, Double selectedCredits){
            HashMap<String,Double> creditMap=new HashMap<>();
            creditMap.put("totalCredits",totalCredits);
            creditMap.put("CompletedCredits",selectedCredits);
            return creditMap;
        }

    @Override
    public String toString() {
        return "CourseStatistics{" +
                "average_grade=" + average_grade +
                ", max_grade=" + max_grade +
                ", min_grade=" + min_grade +
                '}';
    }

    public Double getAverage_grade() {
        return average_grade;
    }

    public void setAverage_grade(Double average_grade) {
        this.average_grade = average_grade;
    }

    public Double getMax_grade() {
        return max_grade;
    }

    public void setMax_grade(Double max_grade) {
        this.max_grade = max_grade;
    }

    public Double getMin_grade() {
        return min_grade;
    }

    public void setMin_grade(Double min_grade) {
        this.min_grade = min_grade;
    }
}
