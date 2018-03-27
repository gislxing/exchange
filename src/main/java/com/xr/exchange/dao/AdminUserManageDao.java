package com.xr.exchange.dao;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.UserBean;
import com.xr.exchange.model.UserListBean;
import com.xr.exchange.model.UserPayVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员-用户管理dao
 *
 * @author Administrator
 * @create 2018/3/20.
 */
public interface AdminUserManageDao {

    List<UserPayVo> getUserPayList(@Param("userPayListBean") UserPayListBean userPayListBean, @Param("loginAdmin") AdminBean loginAdmin);

    List<UserBean> getUsers(@Param("adminListBean") AdminListBean adminListBean, @Param("loginAdmin") AdminBean loginAdmin);

    Integer updateUser(@Param("userListBean") UserListBean userListBean);

}
