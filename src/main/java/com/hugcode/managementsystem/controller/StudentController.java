package com.hugcode.managementsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugcode.managementsystem.common.AppException;
import com.hugcode.managementsystem.common.ResponseResult;
import com.hugcode.managementsystem.common.ResponseStatus;
import com.hugcode.managementsystem.pojo.Student;
import com.hugcode.managementsystem.service.StudentCourseService;
import com.hugcode.managementsystem.service.StudentService;
import com.hugcode.managementsystem.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Tag(name = "StudentController", description = "学生控制器")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/students")
public class StudentController {
    @Resource
    private StudentService studentService;
    @Resource
    private StudentCourseService studentCourseService;

    @Operation(summary = "条件查询学生信息", description = "")
    @GetMapping({"/condition","/{sid}/condition"})
    public ResponseResult getStudentByCondition(@ModelAttribute Student student) {
        List<Student> students = studentService.selectByCondition(student);
        return ResponseResult.success(students);
    }

    @Operation(summary = "查询学生总学分与完成学分", description = "")
    @GetMapping({"credits","/{sid}/credits"})
    public ResponseResult getStudentCredits(@PathVariable(required = false) String sid) {
        return ResponseResult.success(studentCourseService.getCreditsMap(sid));
    }
    @Operation(summary = "添加学生信息", description = "")
    @PostMapping
    //接收student和List students
    public ResponseResult postStudent(@RequestBody Student student) {
        return studentService.addStudent(student) ?
                ResponseResult.success()
                : ResponseResult.error(ResponseStatus.USER_ALREADY_EXIST);
    }
    @Operation(summary = "添加学生的课程", description = "")
    @PostMapping("/{sid}/courses/{cid}")
    public ResponseResult postStudentCourse(@PathVariable String sid, @PathVariable String cid, @RequestBody Map<String, Double> gradeMap) {
        return studentCourseService.addStudentCourse(sid, cid,gradeMap.get("grade")) ?
                ResponseResult.success()
                : ResponseResult.error(ResponseStatus.STUDENT_OR_COURSE_NOT_EXIST);
    }

    @Operation(summary = "批量添加学生信息", description = "")
    @PostMapping("/list")
    public ResponseResult postStudentList(@RequestBody List<Student> students) {
        return studentService.addStudentList(students) ?
                ResponseResult.success()
                : ResponseResult.error(ResponseStatus.USER_ALREADY_EXIST);
    }
    @Operation(summary = "学生登录",description = "")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody Map<String,String>map) throws Exception {
        if(map.get("sid")==null||map.get("password")==null) throw new AppException(ResponseStatus.REQUEST_PARAM_ERROR);
        Student student=new Student();
        student.setSid(map.get("sid"));
        student.setPassword(map.get("password"));
        if(!studentService.login(student)) return ResponseResult.error(ResponseStatus.USER_NOT_EXIST);

        HashMap<String,String> res=new HashMap<>();
        res.put("token", JwtUtil.createJWT(student.getSid()));
        return  ResponseResult.success(res);
    }
    @Operation(summary = "删除学生信息", description = "")
    @DeleteMapping("/{sid}")
    public ResponseResult deleteStudent(@PathVariable String sid) {
        return studentService.deleteBySid(sid) ?
                ResponseResult.success() :
                ResponseResult.error(ResponseStatus.USER_NOT_EXIST);

    }

    @Operation(summary = "删除学生的课程", description = "")
    @DeleteMapping("/{sid}/courses/{cid}")
    public ResponseResult deleteStudentCourse(@PathVariable String sid, @PathVariable String cid) {
        return studentCourseService.deleteStudentCourse(sid, cid) ?
                ResponseResult.success()
                : ResponseResult.error(ResponseStatus.STUDENT_OR_COURSE_NOT_EXIST);
    }
    @Operation(summary = "批量删除学生课程",description = "")
    @DeleteMapping("/{sid}/courses")
    public ResponseResult deleteStudentCourseList(@PathVariable String sid, @RequestBody Map<String,List<String>>map){
        if(map.get("cids")==null) throw new AppException(ResponseStatus.REQUEST_PARAM_ERROR);
        List<String>cids=map.get("cids");
        return studentCourseService.deleteStudentCourseList(sid,cids)?ResponseResult.success():
                ResponseResult.error(ResponseStatus.STUDENT_OR_COURSE_NOT_EXIST);
    }

    @Operation(summary = "批量删除学生信息", description = "")
    @DeleteMapping("/list")
    public ResponseResult deleteStudentList(@RequestBody Map<String, List<String>> map) {
        System.out.println(map.get("sids"));
        if (map.get("sids") == null)
            throw new AppException(ResponseStatus.REQUEST_PARAM_ERROR);
        List<String> sidList = map.get("sids");

        return studentService.deleteBySidList(sidList) ?
                ResponseResult.success() :
                ResponseResult.error(ResponseStatus.USER_NOT_EXIST);

    }

    @Operation(summary = "修改学生信息", description = "")
    @PutMapping("/{sid}")
    public ResponseResult putStudent(@PathVariable String sid,@RequestBody Map<String, Object>requestBody) {
        //TODO 探究ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.convertValue(requestBody.get("student"), Student.class);
        student.setSid(sid);
        List<String> cids = (List<String>) requestBody.get("cids");
        System.out.println(requestBody);
        return studentService.updateStudent(student)&&studentCourseService.addCourseListToStudent(sid,cids) ?
                ResponseResult.success() :
                ResponseResult.error(ResponseStatus.USER_NOT_EXIST);
    }

    @Operation(summary = "修改学生的课程成绩", description = "")
    @PutMapping("/{sid}/courses/{cid}/grade")
    public ResponseResult updateStudentGrade(@PathVariable String sid, @PathVariable String cid, @RequestBody Map<String, Double> gradeMap) {
        Double newGrade = gradeMap.get("grade");
        // 调用服务层方法来更新成绩
        boolean result = studentCourseService.updateGrade(sid, cid, newGrade);
        return result ? ResponseResult.success() : ResponseResult.error(ResponseStatus.ERROR);
    }


}
