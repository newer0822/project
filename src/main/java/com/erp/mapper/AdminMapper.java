package com.erp.mapper;

import com.erp.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    /**
     * 根据用户名以及密码查询用户
     * @param username
     * @param pwd
     * @return
     */
    @Select("select * from admin where username=#{username} and pwd=${pwd}")
    public Admin Login(@Param("username") String username,
                        @Param("pwd") String pwd);

    @Select("select * from admin where username=#{username} ")
    public Admin getAdmin(@Param("username") String username);

}
