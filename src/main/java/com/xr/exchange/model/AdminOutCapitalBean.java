package com.xr.exchange.model;

import java.util.Date;

/**
 * 管理员-出金bean
 *
 * @author Administrator
 * @create 2018/3/30.
 */
public class AdminOutCapitalBean {

    private int id;
    private int adminId;
    private Double popMoney;
    private Date popTime;
    private Integer popFlag;
    private String popName;
    private String popCode;
    private String popAccount;
    private String popPhone;
    private String popIdcard;
    private String popPaynum;
    private String popRemarks;
    private Integer popDo;
    private Date popDotime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Double getPopMoney() {
        return popMoney;
    }

    public void setPopMoney(Double popMoney) {
        this.popMoney = popMoney;
    }

    public Date getPopTime() {
        return popTime;
    }

    public void setPopTime(Date popTime) {
        this.popTime = popTime;
    }

    public Integer getPopFlag() {
        return popFlag;
    }

    public void setPopFlag(Integer popFlag) {
        this.popFlag = popFlag;
    }

    public String getPopName() {
        return popName;
    }

    public void setPopName(String popName) {
        this.popName = popName;
    }

    public String getPopCode() {
        return popCode;
    }

    public void setPopCode(String popCode) {
        this.popCode = popCode;
    }

    public String getPopAccount() {
        return popAccount;
    }

    public void setPopAccount(String popAccount) {
        this.popAccount = popAccount;
    }

    public String getPopPhone() {
        return popPhone;
    }

    public void setPopPhone(String popPhone) {
        this.popPhone = popPhone;
    }

    public String getPopIdcard() {
        return popIdcard;
    }

    public void setPopIdcard(String popIdcard) {
        this.popIdcard = popIdcard;
    }

    public String getPopPaynum() {
        return popPaynum;
    }

    public void setPopPaynum(String popPaynum) {
        this.popPaynum = popPaynum;
    }

    public String getPopRemarks() {
        return popRemarks;
    }

    public void setPopRemarks(String popRemarks) {
        this.popRemarks = popRemarks;
    }

    public Integer getPopDo() {
        return popDo;
    }

    public void setPopDo(Integer popDo) {
        this.popDo = popDo;
    }

    public Date getPopDotime() {
        return popDotime;
    }

    public void setPopDotime(Date popDotime) {
        this.popDotime = popDotime;
    }
}
