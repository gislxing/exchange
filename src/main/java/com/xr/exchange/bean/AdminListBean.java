package com.xr.exchange.bean;

/**
 * ${DESCRIPTION}
 *
 * @author zjw
 * @create 2018/3/22.
 */
public class AdminListBean extends BaseBean{
    private String addStartTime;//注册开始时间
    private String addEndTime;// 注册结束时间
    private String conditions;//模糊搜索条件

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
}
