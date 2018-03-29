package com.xr.exchange.dao;

import com.xr.exchange.model.AdminBankCardBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 银行卡dao
 *
 * @author Administrator
 * @create 2018/3/29.
 */
public interface AdminBankCardDao {

    List<AdminBankCardBean> getAll(@Param("loginAdminId") int loginAdminId);

    int updateStatus(@Param("id") int id, @Param("status") int status);

    int delete(@Param("id") int id);

    int save(@Param("adminBankCardBean") AdminBankCardBean adminBankCardBean);
}
