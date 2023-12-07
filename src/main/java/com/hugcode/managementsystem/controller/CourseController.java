package com.hugcode.managementsystem.controller;

import com.hugcode.managementsystem.common.ResponseResult;
import com.hugcode.managementsystem.pojo.Course;
import com.hugcode.managementsystem.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CourseController", description = "课程控制器")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Resource
    private CourseService courseService;

    @GetMapping("/{sid}")
    public ResponseResult getCourseList(@PathVariable String sid) {
        return ResponseResult.success(courseService.getCourseList(sid));
    }
}
