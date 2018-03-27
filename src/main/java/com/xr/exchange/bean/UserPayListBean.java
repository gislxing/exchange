package com.xr.exchange.bean;

/**
 * ${DESCRIPTION}
 *
 * @author zjw
 * @create 2018/3/26.
 */
public class UserPayListBean extends BaseBean{
    private String addStartTime;//注册开始时间
    private String addEndTime;// 注册结束时间
    private String conditions;//模糊搜索条件
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
