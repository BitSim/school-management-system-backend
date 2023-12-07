package com.hugcode.managementsystem.controller;

import com.hugcode.managementsystem.common.ResponseResult;
import com.hugcode.managementsystem.common.ResponseStatus;
import com.hugcode.managementsystem.pojo.Teacher;
import com.hugcode.managementsystem.service.CourseService;
import com.hugcode.managementsystem.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TeacherController", description = "教师控制器")
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;
    @Operation(summary = "获取全部教师信息",description = "")
    @GetMapping
    public ResponseResult getTeacher(){
        return ResponseResult.success(teacherService.selectAll());
    }
    @Operation(summary = "获取教师所教的每门课程的平均成绩、最高分、最低分")
    @GetMapping("/{tid}/grades/statistics")
    public ResponseResult getGradeStatisticsByTeacher(@PathVariable String tid){
        return ResponseResult.success(courseService.getGradeStatisticsByTeacher(tid));

    }
    @Operation(summary = "为教师添加单个课程",description = "")
    @PostMapping("/{tid}/courses/{cid}")
    public ResponseResult postTeacherToCourse(@PathVariable String tid,@PathVariable String cid){
        return courseService.addTeacherToCourse(tid,cid)?
                ResponseResult.success():ResponseResult.error(ResponseStatus.TEACHER_OR_COURSE_NOT_EXIST);
    }
    @Operation(summary = "修改教师信息",description = "")
    @PutMapping("/{tid}")
    public ResponseResult putTeacher(@PathVariable String tid,@RequestBody Teacher teacher){
        teacher.setTid(tid);
        return teacherService.updateTeacher(teacher)?
                ResponseResult.success():ResponseResult.error(ResponseStatus.TEACHER_NOT_EXIST);
    }
    @Operation(summary = "为教师删除单个课程",description = "")
    @DeleteMapping("/{tid}/courses/{cid}")
    public ResponseResult deleteTeacherToCourse(@PathVariable String tid,@PathVariable String cid){
        return courseService.removeTeacherFromCourse(cid)?
                ResponseResult.success():ResponseResult.error(ResponseStatus.TEACHER_OR_COURSE_NOT_EXIST);
    }

}
