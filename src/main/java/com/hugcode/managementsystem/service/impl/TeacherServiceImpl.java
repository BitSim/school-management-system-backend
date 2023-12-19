package com.hugcode.managementsystem.service.impl;

import com.hugcode.managementsystem.mapper.TeacherMapper;
import com.hugcode.managementsystem.pojo.Teacher;
import com.hugcode.managementsystem.pojo.TeacherStatistics;
import com.hugcode.managementsystem.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectByCondition(Teacher teacher){
        return teacherMapper.selectByCondition(teacher);
    }

    @Override
    public Boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public Boolean deleteTeacher(List<String> tids) {
        teacherMapper.deleteTeacherFromCourse(tids);
        return teacherMapper.deleteTeacher(tids);
    }

    @Override
    public List<Teacher> selectTname() {
        return teacherMapper.selectTname();
    }

    @Override
    public List<TeacherStatistics> getTeacherStatistics() {
        return teacherMapper.getTeacherStatistics();
    }

    @Override
    public boolean insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }
}
