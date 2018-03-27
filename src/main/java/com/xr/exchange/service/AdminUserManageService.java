package com.xr.exchange.service;

import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.model.AdminBean;

import java.util.Map;

/**
 * 管理员-用户service
 *
 * @author Administrator
 * @create 2018/3/26.
 */
public interface AdminUserManageService {
    Map<String, Object> getUserPayList(UserPayListBean userPayListBean, AdminBean loginAdmin);
}
