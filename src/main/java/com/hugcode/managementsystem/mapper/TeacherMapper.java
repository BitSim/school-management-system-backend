package com.hugcode.managementsystem.mapper;

import com.hugcode.managementsystem.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    List<Teacher> selectAll();

    Boolean updateTeacher(Teacher teacher);
}
