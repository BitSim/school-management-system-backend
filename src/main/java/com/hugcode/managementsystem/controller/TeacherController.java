package com.hugcode.managementsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugcode.managementsystem.common.ResponseResult;
import com.hugcode.managementsystem.common.ResponseStatus;
import com.hugcode.managementsystem.pojo.Teacher;
import com.hugcode.managementsystem.service.CourseService;
import com.hugcode.managementsystem.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "TeacherController", description = "教师控制器")
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;

    @Operation(summary = "获取全部教师信息", description = "")
    @GetMapping("/condition")
    public ResponseResult getTeacher(Teacher teacher) {
        return ResponseResult.success(teacherService.selectByCondition(teacher));
    }

    @Operation(summary = "获取全部教师的教师号和姓名")
    @GetMapping
    public ResponseResult getTeacherInfo() {
        return ResponseResult.success(teacherService.selectTname());
    }

    @Operation(summary = "获取教师未教授的课程信息")
    @GetMapping("/{tid}/courses/unselected")
    public ResponseResult getUntaughtCourses(@PathVariable String tid) {
        return ResponseResult.success(courseService.getUntaughtCourses(tid));
    }


    @Operation(summary = "获取不同职称的教师的数量、不同职称的教师的平均工资")
    @GetMapping("/statistics")
    public ResponseResult getTeacherStatistics() {
        return ResponseResult.success(teacherService.getTeacherStatistics());
    }

    @Operation(summary = "获取教师所教的每门课程的平均成绩、最高分、最低分")
    @GetMapping("/{tid}/grades/statistics")
    public ResponseResult getGradeStatisticsByTeacher(@PathVariable String tid) {
        return ResponseResult.success(courseService.getGradeStatisticsByTeacher(tid));

    }

    @Operation(summary = "为教师添加课程", description = "")
    @PostMapping("/{tid}/courses")
    public ResponseResult postTeacherToCourse(@PathVariable String tid, @RequestBody Map<String, List<String>> map) {
        List<String> cids = map.get("cids");
        return courseService.addTeacherToCourse(tid, cids) ?
                ResponseResult.success() : ResponseResult.error(ResponseStatus.TEACHER_OR_COURSE_NOT_EXIST);
    }

    @Operation(summary = "添加教师",description = "")
    @PostMapping
    public ResponseResult postTeacher(@RequestBody Teacher teacher) {

        return teacherService.insertTeacher(teacher)?
                ResponseResult.success() : ResponseResult.error(ResponseStatus.TEACHER_ALREADY_EXIST);
    }


    @Operation(summary = "修改教师信息", description = "")
    @PutMapping("/{tid}")
    public ResponseResult putTeacher(@PathVariable String tid, @RequestBody Map<String, Object> requestBody) {
        System.out.println(requestBody);
        ObjectMapper objectMapper = new ObjectMapper();
        Teacher teacher = objectMapper.convertValue(requestBody.get("teacher"), Teacher.class);
        teacher.setTid(tid);
        List<String> cids = (List<String>) requestBody.get("cids");
        return teacherService.updateTeacher(teacher) && courseService.addTeacherToCourse(tid, cids) ?
                ResponseResult.success() : ResponseResult.error(ResponseStatus.TEACHER_NOT_EXIST);
    }

    @Operation(summary = "为教师删除单个课程", description = "")
    @DeleteMapping("/{tid}/courses/{cid}")
    public ResponseResult deleteTeacherToCourse(@PathVariable String tid, @PathVariable String cid) {
        return courseService.removeTeacherFromCourse(cid) ?
                ResponseResult.success() : ResponseResult.error(ResponseStatus.TEACHER_OR_COURSE_NOT_EXIST);
    }

    @Operation(summary = "批量或单个删除教师信息", description = "")
    @DeleteMapping
    public ResponseResult deleteTeacher(@RequestBody HashMap<String, List<String>> map) {

        List<String> tids = map.get("tids");
        return teacherService.deleteTeacher(tids) ?
                ResponseResult.success() : ResponseResult.error(ResponseStatus.TEACHER_NOT_EXIST);
    }
}
