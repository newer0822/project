package com.erp.service;

import com.erp.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminService {

    public Admin Login(@Param("username") String username,
                       @Param("pwd") String pwd);

    /**
     * 根据员工姓名查询员工信息
     * @param username
     * @return
     */
    public Admin getAdmin(@Param("username") String username);

}
