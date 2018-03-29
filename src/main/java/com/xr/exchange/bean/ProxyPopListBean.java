package com.xr.exchange.bean;

/**
 * ${DESCRIPTION}
 *
 * @author zjw
 * @create 2018/3/26.
 */
public class ProxyPopListBean extends BaseBean{
    private String addStartTime;//申请开始时间
    private String addEndTime;// 申请结束时间
    private String appStartTime;//审核开始时间
    private String appEndTime;// 审核结束时间
    private String conditions;//模糊搜索条件
    private String bankUserName;//提现银行卡户主姓名
    private String bankName;//    提现银行卡名称：
    private String popFlag;//    申请状态，1申请，2通过，3驳回
    private String popDo;//    第三方平台1代付成功，2代付失败

    public String getAppStartTime() {
        return appStartTime;
    }

    public void setAppStartTime(String appStartTime) {
        this.appStartTime = appStartTime;
    }

    public String getAppEndTime() {
        return appEndTime;
    }

    public void setAppEndTime(String appEndTime) {
        this.appEndTime = appEndTime;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPopFlag() {
        return popFlag;
    }

    public void setPopFlag(String popFlag) {
        this.popFlag = popFlag;
    }

    public String getPopDo() {
        return popDo;
    }

    public void setPopDo(String popDo) {
        this.popDo = popDo;
    }

    private String payFlag;//支付状态
    private String payType;//1支付宝，2微信，3快捷支付，4QQ支付，5网银支付

    public String getAddStartTime() {
        return addStartTime;
    }

    public void setAddStartTime(String addStartTime) {
        this.addStartTime = addStartTime;
    }

    public String getAddEndTime() {
        return addEndTime;
    }

    public void setAddEndTime(String addEndTime) {
        this.addEndTime = addEndTime;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
