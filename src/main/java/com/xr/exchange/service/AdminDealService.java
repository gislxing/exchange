package com.xr.exchange.service;

import com.xr.exchange.bean.UserParamBean;
import com.xr.exchange.model.AdminBean;

import java.util.Map;

/**
 * 管理员-用户交易service
 *
 * @author Administrator
 * @create 2018/3/28.
 */
public interface AdminDealService {

    Map<String,Object> getUserDealList(UserParamBean userParamBean, AdminBean loginAdmin);

}
