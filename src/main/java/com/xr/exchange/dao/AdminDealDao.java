package com.xr.exchange.dao;

import com.xr.exchange.bean.AdminUserDealBean;
import com.xr.exchange.bean.UserParamBean;
import com.xr.exchange.model.AdminBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员-商品dao
 *
 * @author Administrator
 * @create 2018/3/28.
 */
public interface AdminDealDao {

    List<AdminUserDealBean> getUserDealList(@Param("userParamBean") UserParamBean userParamBean, @Param("loginAdmin") AdminBean loginAdmin);

}
