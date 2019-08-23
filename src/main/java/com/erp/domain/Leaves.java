package com.erp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类，请假条信息
 */
public class Leaves implements Serializable {
    private static final long serialVersionUID = -820596262923226975L;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public void setCount(Double total) {
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

    public Leaves(Integer lid, Integer aid, String types, String lstate, Date starttime, Date endtime, Double total, String adminsstate, Integer remark, String lopinion, String mopinion) {
        this.lid = lid;
        this.aid = aid;
        this.types = types;
        this.lstate = lstate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.total =total;
        this.adminsstate = adminsstate;
        this.remark = remark;
        this.lopinion = lopinion;
        this.mopinion = mopinion;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Leaves() {
    }

    @Override
    public String toString() {
        return "Leaves{" +
                "lid=" + lid +
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
