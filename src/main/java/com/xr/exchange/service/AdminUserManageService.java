package com.xr.exchange.service;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.bean.UserPopListBean;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.UserListBean;
import com.xr.exchange.model.UserPopVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 管理员-用户service
 *
 * @author Administrator
 * @create 2018/3/26.
 */
public interface AdminUserManageService {

    Map<String, Object> getUserPayList(UserPayListBean userPayListBean, AdminBean loginAdmin);

    Map<String, Object> getUserPopList(UserPopListBean userPopListBean, AdminBean loginAdmin);
    @Transactional
    Boolean rebutPop(UserPopVo userPopVo);

    Map<String,Object> getUsers(AdminListBean adminListBean, AdminBean loginAdmin);

    Integer updateUser(UserListBean userListBean);

}
