package com.xr.exchange.bean;

/**
 * 管理员-用户前台传递参数
 *
 * @author Administrator
 * @create 2018/3/28.
 */
public class UserParamBean extends BaseBean {

    /**
     * 模糊搜索条件
     */
    private String conditions;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 交易类型(预留)
     */
    private String dealType;

    /**
     * 结算标志
     * 0: 未结算，1：已结算
     */
    private Integer settlementFlag;

    public Integer getSettlementFlag() {
        return settlementFlag;
    }

    public void setSettlementFlag(Integer settlementFlag) {
        this.settlementFlag = settlementFlag;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }
}
