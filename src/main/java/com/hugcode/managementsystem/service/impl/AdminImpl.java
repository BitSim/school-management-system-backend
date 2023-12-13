package com.hugcode.managementsystem.service.impl;

import com.hugcode.managementsystem.mapper.AdminMapper;
import com.hugcode.managementsystem.pojo.Admin;
import com.hugcode.managementsystem.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("AdminService")
public class AdminImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public boolean login(Admin admin) {
        return adminMapper.login(admin) > 0;
    }
}
