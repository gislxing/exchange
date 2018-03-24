package com.xr.exchange.model;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author zjw
 * @create 2018/3/21.
 */
public class AdminBean {
    private String[] adminLevel = {"", "交易所", "运营中心", "综合会员", "微圈代理"};

    Integer id;
    String username;
    String password;
    String realname;
    String phone;
    int level;
    Double money;
    Float backRatio;
    Float redRatio;
    String companyName;
    String companyLead;
    String companyPhone;
    String companyTel;
    String companyAddress;
    Integer parentId;
    Date lastLoginTime;
    String lastLoginIp;
    Integer status;
    Date addTime;

    String showLevel;

    public String getShowLevel() {
        return showLevel;
    }

    public void setShowLevel(int level) {
        this.showLevel = adminLevel[level];
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.setShowLevel(level);
        this.level = level;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Float getBackRatio() {
        return backRatio;
    }

    public void setBackRatio(Float backRatio) {
        this.backRatio = backRatio;
    }

    public Float getRedRatio() {
        return redRatio;
    }

    public void setRedRatio(Float redRatio) {
        this.redRatio = redRatio;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLead() {
        return companyLead;
    }

    public void setCompanyLead(String companyLead) {
        this.companyLead = companyLead;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
