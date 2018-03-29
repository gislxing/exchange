package com.xr.exchange.model;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *客户入金明细vo
 * @author zjw
 * @create 2018/3/26.
 */
public class UserPopVo extends UserBean {
    private Integer popId;//主键
    private Integer userId;//用户id
    private Float popMoney;//申请提现金额
    private Date popTime;//申请提现时间
    private Date popAppTime;//审核时间
    private int popFlag;//申请状态，1申请，2通过，3驳回
    private String popName;//银行开户主姓名
    private String popCode;//银行卡卡号
    private String popAccount;//银行卡名称，中国银行
    private String popPhone;//银行卡预留手机号
    private String popIdcard;//银行卡预留户主身份证号
    private String popPaynum;//出金订单号(自己的)
    private int popDo;//    第三方平台1代付成功，2代付失败

    private String zongheName;
    private String weiquanName;
    private String yunyingName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPopId() {
        return popId;
    }

    public void setPopId(Integer popId) {
        this.popId = popId;
    }

    public Float getPopMoney() {
        return popMoney;
    }

    public void setPopMoney(Float popMoney) {
        this.popMoney = popMoney;
    }



    public Date getPopTime() {
        return popTime;
    }

    public void setPopTime(Date popTime) {
        this.popTime = popTime;
    }

    public Date getPopAppTime() {
        return popAppTime;
    }

    public void setPopAppTime(Date popAppTime) {
        this.popAppTime = popAppTime;
    }

    public int getPopFlag() {
        return popFlag;
    }

    public void setPopFlag(int popFlag) {
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

    public int getPopDo() {
        return popDo;
    }

    public void setPopDo(int popDo) {
        this.popDo = popDo;
    }

    public String getZongheName() {
        return zongheName;
    }

    public void setZongheName(String zongheName) {
        this.zongheName = zongheName;
    }

    public String getWeiquanName() {
        return weiquanName;
    }

    public void setWeiquanName(String weiquanName) {
        this.weiquanName = weiquanName;
    }

    public String getYunyingName() {
        return yunyingName;
    }

    public void setYunyingName(String yunyingName) {
        this.yunyingName = yunyingName;
    }
}
