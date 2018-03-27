package com.xr.exchange.model;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *客户入金明细vo
 * @author zjw
 * @create 2018/3/26.
 */
public class UserPayVo extends UserBean {
    private int payType;//1支付宝，2微信，3快捷支付，4QQ支付，5网银支付
    private Float payMoney;//支付金额
    private  int payFlag;//支付状态，1未支付，2支付成功,3支付失败
    private Date payTime;//支付时间
    private String payNo;//交易订单号（自己的）
    private String outTradeNo;//上游订单号
    private String zongheName;
    private String weiquanName;
    private String yunyingName;

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Float getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Float payMoney) {
        this.payMoney = payMoney;
    }

    public int getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(int payFlag) {
        this.payFlag = payFlag;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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
