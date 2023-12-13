package com.hugcode.managementsystem.service;

import com.hugcode.managementsystem.pojo.Student;
import org.apache.catalina.User;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> selectAll();
    List<Student> selectByCondition(Student student);
    boolean addStudentList(List<Student> students);
    boolean addStudent(Student student);

    boolean deleteStudentList(List<Student> students);
    boolean deleteBySid(String sid);

    boolean updateStudent(Student students);
    Student findCourseBySid(String sid);
    boolean deleteBySidList(List<String> sids);

    boolean updatePassword(String sid, String newPassword);

    boolean login(Student student);

    boolean resetPassword(String sid, String password);
}
