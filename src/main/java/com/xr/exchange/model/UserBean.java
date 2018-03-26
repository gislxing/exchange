package com.xr.exchange.model;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author zjw
 * @create 2018/3/26.
 */
public class UserBean {
    private Integer id;
    private String username;
    private String password;
    private String avatarPath;
    private String realname;
    private String sex;
    private Float money;
    private Integer refreeId;
    private Integer zongheId;
    private Integer yunyingId;
    private Integer jiaoyisuoId;
    private int tradeable;
    private int loginType;
    private int chujinType;
    private Date lastLoginTime;
    private String lastLoginIp;
    private Date addTime;
    private int autonym;
    private String cardShou;
    private String cardCode;
    private String cardZheng;
    private String cardFan;

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

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public int getTradeable() {
        return tradeable;
    }

    public void setTradeable(int tradeable) {
        this.tradeable = tradeable;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getChujinType() {
        return chujinType;
    }

    public void setChujinType(int chujinType) {
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

    public int getAutonym() {
        return autonym;
    }

    public void setAutonym(int autonym) {
        this.autonym = autonym;
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

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
