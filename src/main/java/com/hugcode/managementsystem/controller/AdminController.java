package com.hugcode.managementsystem.controller;

import com.hugcode.managementsystem.common.AppException;
import com.hugcode.managementsystem.common.ResponseResult;
import com.hugcode.managementsystem.common.ResponseStatus;
import com.hugcode.managementsystem.pojo.Admin;
import com.hugcode.managementsystem.pojo.Student;
import com.hugcode.managementsystem.service.AdminService;
import com.hugcode.managementsystem.util.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "AdminController", description = "管理员控制器")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/admins")
public class AdminController {
    @Resource
    private AdminService adminService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody Map<String, String> map) throws Exception {
        if(map.get("username")==null||map.get("password")==null) throw new AppException(ResponseStatus.REQUEST_PARAM_ERROR);
        Admin admin=new Admin();
        admin.setAdminId(map.get("username"));
        admin.setAdminPassword(map.get("password"));
        if(!adminService.login(admin)) return ResponseResult.error(ResponseStatus.USER_NOT_EXIST);

        HashMap<String,String> res=new HashMap<>();
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "admin");
        res.put("token", JwtUtil.createJWT(header,admin.getAdminId()));
        return  ResponseResult.success(res);
    }
    @GetMapping
    public ResponseResult initGet(){
        return ResponseResult.success();
    }
}
