package com.hugcode.managementsystem.controller;

import com.hugcode.managementsystem.common.ResponseResult;
import com.hugcode.managementsystem.common.ResponseStatus;
import com.hugcode.managementsystem.pojo.Course;
import com.hugcode.managementsystem.pojo.StudentCourse;
import com.hugcode.managementsystem.service.CourseService;
import com.hugcode.managementsystem.service.StudentCourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "CourseController", description = "课程控制器")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Resource
    private CourseService courseService;
    @Resource
    private StudentCourseService studentCourseService;

    @GetMapping("/{sid}")
    public ResponseResult getCourseList(@PathVariable String sid) {
        return ResponseResult.success(courseService.getCourseList(sid));
    }
    @GetMapping("/condition")
    public ResponseResult getCourseByCondition(@ModelAttribute Course course) {
        return ResponseResult.success(courseService.selectByCondition(course));
    }
    @PostMapping
    public ResponseResult postCourse(@RequestBody Course course){
        return courseService.insertCourse(course)?
                ResponseResult.success()
                :ResponseResult.error(ResponseStatus.COURSE_EXIST);
    }

    @DeleteMapping
    public ResponseResult deleteCourse(@RequestBody Map<String,List<String>> map) {
        List<String> cids = map.get("cids");
        return  studentCourseService.deleteCourseList(cids)&&
        courseService.deleteCourseList(cids)?ResponseResult.success():
                ResponseResult.error(ResponseStatus.COURSE_NOT_EXIST);

    }
    @PutMapping("/{cid}")
    public ResponseResult putCourse(@PathVariable String cid,@RequestBody Course course){
        System.out.println(course);
        return courseService.updateCourse(cid,course) ?
                ResponseResult.success()
                : ResponseResult.error(ResponseStatus.COURSE_NOT_EXIST);
    }
}
