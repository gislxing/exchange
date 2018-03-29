package com.xr.exchange.bean;

/**
 * 管理员-银行卡参数类
 *
 * @author Administrator
 * @create 2018/3/29.
 */
public class AdminBankCardParamBean extends BaseBean{

    private int loginAdminId;
    private int id;
    private int status;
    private int bankCardid;

    public int getBankCardid() {
        return bankCardid;
    }

    public void setBankCardid(int bankCardid) {
        this.bankCardid = bankCardid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLoginAdminId() {
        return loginAdminId;
    }

    public void setLoginAdminId(int loginAdminId) {
        this.loginAdminId = loginAdminId;
    }
}
