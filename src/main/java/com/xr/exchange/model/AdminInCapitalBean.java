package com.xr.exchange.model;

/**
 * 管理员-入金bean
 *
 * @author Administrator
 * @create 2018/3/30.
 */
public class AdminInCapitalBean {

    private Integer id;
    private Integer adminId;
    private Integer money;
    private Integer payFlag;
    private Integer payTime;
    private Integer payNo;
    private Integer payType;
    private Integer outTradeNo;
    private Integer remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(Integer payFlag) {
        this.payFlag = payFlag;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getPayNo() {
        return payNo;
    }

    public void setPayNo(Integer payNo) {
        this.payNo = payNo;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(Integer outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }
}
