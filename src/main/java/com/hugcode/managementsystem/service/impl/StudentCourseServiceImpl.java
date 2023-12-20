package com.hugcode.managementsystem.service.impl;

import com.hugcode.managementsystem.mapper.StudentCourseMapper;
import com.hugcode.managementsystem.pojo.CourseStatistics;
import com.hugcode.managementsystem.pojo.StudentCourse;
import com.hugcode.managementsystem.service.StudentCourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("StudentCourseService")
public class StudentCourseServiceImpl implements StudentCourseService {
    @Resource
    private StudentCourseMapper studentCourseMapper;
    @Override
    public boolean deleteBySidList(List<String> sids) {
        return studentCourseMapper.deleteBySidList(sids);
    }
    @Override
    public boolean deleteStudentCourse(String sid, String cid) {
        return studentCourseMapper.deleteStudentCourse(sid, cid);
    }
    @Override
    public boolean deleteStudentCourseList(String sid,List<String> cids){
        return studentCourseMapper.deleteStudentCourseList(sid,cids);
    }
    @Override
    public boolean updateGrade(String sid, String cid, Double newGrade) {
        return studentCourseMapper.updateGrade(sid, cid, newGrade);
    }
    @Override
    public boolean addStudentCourse(String sid, String cid) {
        return studentCourseMapper.addStudentCourse(sid, cid);
    }

    @Override
    public HashMap<String, Double> getCreditsMap(String sid) {
            return CourseStatistics.getCreditMap(studentCourseMapper.getTotalCredits(sid),studentCourseMapper.getCompletedCredits(sid));
    }

    @Override
    public boolean addCourseListToStudent(String sid, List<String> cids) {
        if (cids.size()==0){
            return true;
        }
        return studentCourseMapper.addCourseListToStudent(sid, cids);
    }

    @Override
    public boolean deleteCourseList(List<String>cids) {
        return studentCourseMapper.deleteCourseList(cids);
    }

    @Override
    public List<StudentCourse> selectByCondition(String sid, StudentCourse studentCourse) {
        return studentCourseMapper.selectByCondition(sid, studentCourse);
    }
}
