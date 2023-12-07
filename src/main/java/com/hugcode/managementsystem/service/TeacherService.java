package com.hugcode.managementsystem.service;

import com.hugcode.managementsystem.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> selectAll();

    Boolean updateTeacher(Teacher teacher);
}
