package com.hugcode.managementsystem.service.impl;

import com.hugcode.managementsystem.mapper.StudentMapper;
import com.hugcode.managementsystem.pojo.Student;
import com.hugcode.managementsystem.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }
    @Override
    public List<Student> selectByCondition(Student student) {return studentMapper.selectByCondition(student);}

    @Override
    public boolean addStudentList(List<Student> students) {return studentMapper.addStudentList(students);}
    @Override
    public boolean addStudent(Student student) { return studentMapper.addStudent(student);}

    @Override
    public boolean deleteBySid(String sid){return  studentMapper.deleteBySid(sid);}
    @Override
    public boolean deleteStudentList(List<Student> students) {return studentMapper.deleteStudentList(students);}

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student findCourseBySid(String sid) { return studentMapper.findCourseBySid(sid); }

    @Override
    public boolean deleteBySidList(List<String> sids) {return studentMapper.deleteBySidList(sids);}
    @Override
    public boolean updatePassword(String sid, String newPassword) {

        return studentMapper.updatePassword(sid, newPassword);
    }
    @Override
    public boolean login(Student student) {
        return studentMapper.login(student) > 0;
    }


    @Override
    public boolean resetPassword(String sid, String password) {
        return studentMapper.resetPassword(sid, password);
    }
}

