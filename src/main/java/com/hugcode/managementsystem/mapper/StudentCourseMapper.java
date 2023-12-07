package com.hugcode.managementsystem.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseMapper {
    Boolean deleteBySidList(@Param("sids") List<String>sids);

    Boolean deleteStudentCourse(@Param("sid") String sid, @Param("cid") String cid);

    Boolean updateGrade(@Param("sid") String sid, @Param("cid") String cid, @Param("grade") Double newGrade);

    Boolean addStudentCourse(@Param("sid") String sid, @Param("cid") String cid,@Param("grade") Double grade);
    Boolean addCourseListToStudent(@Param("sid") String sid, @Param("cids") List<String> cids);
    Double getTotalCredits(@Param("sid") String sid);

    Double getCompletedCredits(@Param("sid") String sid);

    Boolean deleteStudentCourseList(@Param("sid") String sid,@Param("cids") List<String> cids);
}
