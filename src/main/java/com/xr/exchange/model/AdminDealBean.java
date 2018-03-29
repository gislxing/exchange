package com.xr.exchange.model;

import java.util.Date;

/**
 * 管理员-用户交易
 *
 * @author Administrator
 * @create 2018/3/28.
 */
public class AdminDealBean {

    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Double buyPrice;
    private Double dealPrice;
    private Integer buyType;
    private Date buyAddTime;
    private Date buyEndTime;
    private Double buyMoney;
    private Double buyRealMoney;
    private Double buyGain;
    private int overFlag;
    private Float chargeMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

    public Date getBuyAddTime() {
        return buyAddTime;
    }

    public void setBuyAddTime(Date buyAddTime) {
        this.buyAddTime = buyAddTime;
    }

    public Date getBuyEndTime() {
        return buyEndTime;
    }

    public void setBuyEndTime(Date buyEndTime) {
        this.buyEndTime = buyEndTime;
    }

    public Double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(Double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Double getBuyRealMoney() {
        return buyRealMoney;
    }

    public void setBuyRealMoney(Double buyRealMoney) {
        this.buyRealMoney = buyRealMoney;
    }

    public Double getBuyGain() {
        return buyGain;
    }

    public void setBuyGain(Double buyGain) {
        this.buyGain = buyGain;
    }

    public int getOverFlag() {
        return overFlag;
    }

    public void setOverFlag(int overFlag) {
        this.overFlag = overFlag;
    }

    public Float getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(Float chargeMoney) {
        this.chargeMoney = chargeMoney;
    }
}
