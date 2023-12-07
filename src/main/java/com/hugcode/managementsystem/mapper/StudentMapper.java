package com.hugcode.managementsystem.mapper;

import com.hugcode.managementsystem.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    List<Student> selectAll();
    List<Student> selectByCondition(Student student);
    List<Student> selectBySid(String sid);
    boolean addStudent(Student student);

    boolean addStudentList(List<Student>students);
    boolean deleteBySid(String sid);

    boolean deleteStudentList(List<Student>students);
    boolean updateStudent(Student student);
    Student findCourseBySid(@Param("sid") String sid);
    boolean updateCourseGrade(Student student);
    boolean updatePassword( @Param("sid") String sid,@Param("password") String password);
    boolean deleteBySidList(List<String> sids);

    Integer login(Student student);
}
