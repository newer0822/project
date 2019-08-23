package com.erp.service.imp;

import com.erp.domain.Admin;
import com.erp.mapper.AdminMapper;
import com.erp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//按F进入坦克

//88888
@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
//131231231231231231312312312312312312
    /**
     * 验证登陆信息
     * @param username
     * @param pwd
     * @return
     */
    @Override
    public Admin Login(String username, String pwd) {
        return adminMapper.Login(username,pwd);
    }

    @Override
    public Admin getAdmin(String username) {
        return adminMapper.getAdmin(username);
    }


}
