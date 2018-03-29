package com.xr.exchange.model;

import java.util.Date;

/**
 * 管理员-用户列表
 *
 * @author Administrator
 * @create 2018/3/26.
 */
public class UserListBean {

    private Integer id;
    private String username;
    private String realname;
    private Float money;
    private Integer refreeId;
    private Integer zongheId;
    private Integer yunyingId;
    private Integer jiaoyisuoId;
    private Integer tradeable;
    private Integer loginType;
    private Integer chujinType;
    private Date lastLoginTime;
    private String lastLoginIp;
    private Date addTime;
    private String cardShou;
    private String cardCode;
    private String cardZheng;
    private String cardFan;
    private String compMemberName;
    private String microProxyName;
    private String password;

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getRefreeId() {
        return refreeId;
    }

    public void setRefreeId(Integer refreeId) {
        this.refreeId = refreeId;
    }

    public Integer getZongheId() {
        return zongheId;
    }

    public void setZongheId(Integer zongheId) {
        this.zongheId = zongheId;
    }

    public Integer getYunyingId() {
        return yunyingId;
    }

    public void setYunyingId(Integer yunyingId) {
        this.yunyingId = yunyingId;
    }

    public Integer getJiaoyisuoId() {
        return jiaoyisuoId;
    }

    public void setJiaoyisuoId(Integer jiaoyisuoId) {
        this.jiaoyisuoId = jiaoyisuoId;
    }

    public Integer getTradeable() {
        return tradeable;
    }

    public void setTradeable(Integer tradeable) {
        this.tradeable = tradeable;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public Integer getChujinType() {
        return chujinType;
    }

    public void setChujinType(Integer chujinType) {
        this.chujinType = chujinType;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCardShou() {
        return cardShou;
    }

    public void setCardShou(String cardShou) {
        this.cardShou = cardShou;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardZheng() {
        return cardZheng;
    }

    public void setCardZheng(String cardZheng) {
        this.cardZheng = cardZheng;
    }

    public String getCardFan() {
        return cardFan;
    }

    public void setCardFan(String cardFan) {
        this.cardFan = cardFan;
    }

    public String getCompMemberName() {
        return compMemberName;
    }

    public void setCompMemberName(String compMemberName) {
        this.compMemberName = compMemberName;
    }

    public String getMicroProxyName() {
        return microProxyName;
    }

    public void setMicroProxyName(String microProxyName) {
        this.microProxyName = microProxyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
