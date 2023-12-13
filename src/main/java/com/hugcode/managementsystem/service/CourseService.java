package com.hugcode.managementsystem.service;

import com.hugcode.managementsystem.pojo.Course;
import com.hugcode.managementsystem.pojo.CourseStatistics;

import java.util.List;

public interface CourseService {
    Boolean addTeacherToCourse(String tid,String cid);

    Boolean removeTeacherFromCourse(String cid);

    List<CourseStatistics> getGradeStatisticsByTeacher(String tid);

    List<Course> getCourseList(String sid);

    List<Course> selectByCondition(Course course);

    Boolean updateCourse(String cid, Course course);

    Boolean deleteCourseList(List<String> cids);

    Boolean insertCourse(Course course);
}
