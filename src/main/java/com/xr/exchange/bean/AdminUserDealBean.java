package com.xr.exchange.bean;

import com.xr.exchange.model.AdminDealBean;

/**
 * 管理员-用户交易
 *
 * @author Administrator
 * @create 2018/3/29.
 */
public class AdminUserDealBean extends AdminDealBean {

    private String username;
    private String realname;
    private String compMemberName;
    private String microProxyName;
    private String goodsName;

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
