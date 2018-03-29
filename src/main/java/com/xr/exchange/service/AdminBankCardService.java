package com.xr.exchange.service;

import com.xr.exchange.bean.AdminBankCardParamBean;
import com.xr.exchange.model.AdminBankCardBean;

import java.util.Map;

/**
 * 银行卡service
 *
 * @author Administrator
 * @create 2018/3/29.
 */
public interface AdminBankCardService {

    /**
     * 查询用户所有银行卡
     * @param adminBankCardParamBean
     * @return
     */
    Map<String, Object> getAll(AdminBankCardParamBean adminBankCardParamBean);

    /**
     * 更新银行卡状态
     * @param adminBankCardParamBean
     *      更新对象bean
     * @return
     */
    boolean updateStatus(AdminBankCardParamBean adminBankCardParamBean);

    /**
     * 删除银行卡
     * @param id
     *      要删除的银行卡主键id
     * @return
     */
    boolean delete(int id);

    /**
     * 保存银行卡
     * @param adminBankCardBean
     * @return
     */
    boolean save(AdminBankCardBean adminBankCardBean);
}
