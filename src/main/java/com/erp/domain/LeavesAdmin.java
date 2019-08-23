package com.erp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class LeavesAdmin implements Serializable {
    private static final long serialVersionUID = 2779380063980173290L;
    private Integer id;//用户id
    private String username;//用户名
    private String pwd;//密码
    private Integer remarks;//用户标识 1，普通员工，2，部门经理，3，总经理
    private Integer lid;//请假条编号
    private  Integer aid;//用户编号
    private String types;//请假类型
    private String lstate;//审批状态
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//页面发送数据到服务器
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//服务器数据加载到页面
    private Date starttime;//请假开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//页面发送数据到服务器
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//服务器数据加载到页面
    private Date endtime;//请假结束时间内;
    private Double total;//请假合计天数
    private String adminsstate;//员工状态
    private Integer remark;//标记
    private String lopinion;//部门经理意见
    private String mopinion;//总经理意见

    public LeavesAdmin(Integer id, String username, String pwd, Integer remarks, Integer lid, Integer aid, String types, String lstate, Date starttime, Date endtime, Double total, String adminsstate, Integer remark, String lopinion, String mopinion) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.remarks = remarks;
        this.lid = lid;
        this.aid = aid;
        this.types = types;
        this.lstate = lstate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.total = total;
        this.adminsstate = adminsstate;
        this.remark = remark;
        this.lopinion = lopinion;
        this.mopinion = mopinion;
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

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getLstate() {
        return lstate;
    }

    public void setLstate(String lstate) {
        this.lstate = lstate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getAdminsstate() {
        return adminsstate;
    }

    public void setAdminsstate(String adminsstate) {
        this.adminsstate = adminsstate;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    public String getLopinion() {
        return lopinion;
    }

    public void setLopinion(String lopinion) {
        this.lopinion = lopinion;
    }

    public String getMopinion() {
        return mopinion;
    }

    public void setMopinion(String mopinion) {
        this.mopinion = mopinion;
    }

    public LeavesAdmin() {
    }

    @Override
    public String toString() {
        return "LeavesAdmin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", remarks=" + remarks +
                ", lid=" + lid +
                ", aid=" + aid +
                ", types='" + types + '\'' +
                ", lstate='" + lstate + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", total=" + total +
                ", adminsstate='" + adminsstate + '\'' +
                ", remark=" + remark +
                ", lopinion='" + lopinion + '\'' +
                ", mopinion='" + mopinion + '\'' +
                '}';
    }
}
