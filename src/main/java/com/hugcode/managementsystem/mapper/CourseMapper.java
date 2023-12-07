package com.hugcode.managementsystem.mapper;

import com.hugcode.managementsystem.pojo.Course;
import com.hugcode.managementsystem.pojo.CourseStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    Boolean addTeacherToCourse(@Param("tid") String tid, @Param("cid") String cid);

    Boolean removeTeacherFromCourse(String cid);

    List<CourseStatistics> getCourseStatisticsByTeacher(String tid);

    List<Course> getCourseList(String sid);
}
