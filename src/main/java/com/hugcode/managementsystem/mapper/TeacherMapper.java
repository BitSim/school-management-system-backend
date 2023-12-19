package com.hugcode.managementsystem.mapper;

import com.hugcode.managementsystem.pojo.Teacher;
import com.hugcode.managementsystem.pojo.TeacherStatistics;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    List<Teacher> selectByCondition(Teacher teacher);

    Boolean updateTeacher(Teacher teacher);

    Boolean deleteTeacher(List<String> tids);
    Boolean deleteTeacherFromCourse(List<String> tids);

    List<Teacher> selectTname();

    List<TeacherStatistics> getTeacherStatistics();

    boolean insertTeacher(Teacher teacher);
}
