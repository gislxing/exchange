package com.xr.exchange.model;

/**
 * 银行卡bean
 *
 * @author Administrator
 * @create 2018/3/29.
 */
public class AdminBankCardBean {

    private Integer id;
    private Integer adminId;
    private String accountNo;
    private String accountName;
    private String bankName;
    private String bankPhone;
    private String bankIdcard;
    private Integer bankFlag;

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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getBankIdcard() {
        return bankIdcard;
    }

    public void setBankIdcard(String bankIdcard) {
        this.bankIdcard = bankIdcard;
    }

    public Integer getBankFlag() {
        return bankFlag;
    }

    public void setBankFlag(Integer bankFlag) {
        this.bankFlag = bankFlag;
    }
}
