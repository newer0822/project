package com.erp.domain;

import java.io.Serializable;

/**
 * 实体类，用户表
 */

public class Admin implements Serializable {
    private static final long serialVersionUID = 7388503818826067709L;
    private Integer id;//用户id
    private String username;//用户名
    private String pwd;//密码
    private Integer remarks;//用户标识 1，普通员工，2，部门经理，3，总经理

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getRemark() {
        return remarks;
    }

    public void setRemark(Integer remark) {
        this.remarks = remarks;
    }

    public Admin(Integer id, String username, String pwd, Integer remarks) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.remarks = remarks;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", remark=" + remarks +
                '}';
    }
}
