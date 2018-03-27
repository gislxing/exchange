package com.xr.exchange.service;

import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.UserListBean;
import com.xr.exchange.bean.AdminListBean;

import java.util.Map;

/**
 * 管理员-用户service
 *
 * @author Administrator
 * @create 2018/3/26.
 */
public interface AdminUserManageService {
    Map<String, Object> getUserPayList(UserPayListBean userPayListBean, AdminBean loginAdmin);

    Map<String,Object> getUsers(AdminListBean adminListBean, AdminBean loginAdmin);

    Integer updateUser(UserListBean userListBean);
}
