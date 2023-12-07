package com.hugcode.managementsystem.service;

import com.hugcode.managementsystem.pojo.Course;
import com.hugcode.managementsystem.pojo.CourseStatistics;

import java.util.List;

public interface CourseService {
    Boolean addTeacherToCourse(String tid,String cid);

    Boolean removeTeacherFromCourse(String cid);

    List<CourseStatistics> getGradeStatisticsByTeacher(String tid);

    List<Course> getCourseList(String sid);
}
