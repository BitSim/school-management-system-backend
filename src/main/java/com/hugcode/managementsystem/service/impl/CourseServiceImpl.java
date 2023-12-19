package com.hugcode.managementsystem.service.impl;

import com.hugcode.managementsystem.mapper.CourseMapper;
import com.hugcode.managementsystem.pojo.Course;
import com.hugcode.managementsystem.pojo.CourseStatistics;
import com.hugcode.managementsystem.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public Boolean removeTeacherFromCourse(String cid) {
        return courseMapper.removeTeacherFromCourse(cid);
    }

    @Override
    public Boolean addTeacherToCourse(String tid, List<String> cids) {
        return courseMapper.addTeacherToCourse(tid,cids);
    }

    @Override
    public List<CourseStatistics> getGradeStatisticsByTeacher(String tid) {
        return courseMapper.getCourseStatisticsByTeacher(tid);
    }

    @Override
    public List<Course> getUnselectedCourses(String sid) {
        return courseMapper.getUnselectedCourses(sid);
    }

    @Override
    public List<Course> selectByCondition(Course course) {
        return courseMapper.selectByCondition(course);
    }

    @Override
    public Boolean updateCourse(String cid, Course course) {
        return courseMapper.updateCourse(cid,course);

    }

    @Override
    public Boolean deleteCourseList(List<String> cids) {
        return courseMapper.deleteCourseList(cids);
    }

    @Override
    public Boolean insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }
    @Override
    public List<Course> getUntaughtCourses(String tid) {
        return courseMapper.getUntaughtCourses(tid);
    }
}
