package com.hugcode.managementsystem.service;

import com.hugcode.managementsystem.pojo.Teacher;
import com.hugcode.managementsystem.pojo.TeacherStatistics;

import java.util.HashMap;
import java.util.List;

public interface TeacherService {
    List<Teacher> selectByCondition(Teacher teacher);

    Boolean updateTeacher(Teacher teacher);

    Boolean deleteTeacher(List<String> tids);

    List<Teacher> selectTname();

    List<TeacherStatistics> getTeacherStatistics();

    boolean insertTeacher(Teacher teacher);
}
