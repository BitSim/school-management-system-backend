package com.hugcode.managementsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentCourseService {
    boolean deleteBySidList(List<String> sids);

    boolean deleteStudentCourse(String sid, String cid);
    boolean deleteStudentCourseList(String sid,List<String>cids);

    boolean updateGrade(String sid, String cid, Double newGrade);

    boolean addStudentCourse(String sid, String cid,Double grade);

    HashMap<String,Double> getCreditsMap(String sid);


    boolean addCourseListToStudent(String sid, List<String> cids);
}
