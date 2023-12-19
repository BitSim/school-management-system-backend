package com.hugcode.managementsystem.mapper;

import com.hugcode.managementsystem.pojo.Course;
import com.hugcode.managementsystem.pojo.CourseStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    Boolean addTeacherToCourse(@Param("tid") String tid, @Param("cids") List<String> cids);

    Boolean removeTeacherFromCourse(String cid);

    List<CourseStatistics> getCourseStatisticsByTeacher(String tid);

    List<Course> getUnselectedCourses(String sid);

    List<Course> selectByCondition(Course course);

    Boolean updateCourse(@Param("cid") String cid,@Param("course") Course course);

    Boolean deleteCourseList(List<String> cids);

    Boolean insertCourse(Course course);

    List<Course> getUntaughtCourses(String tid);
}
