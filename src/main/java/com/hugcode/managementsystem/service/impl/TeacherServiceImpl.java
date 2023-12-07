package com.hugcode.managementsystem.service.impl;

import com.hugcode.managementsystem.mapper.TeacherMapper;
import com.hugcode.managementsystem.pojo.Teacher;
import com.hugcode.managementsystem.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectAll(){
        return teacherMapper.selectAll();
    }

    @Override
    public Boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }
}
