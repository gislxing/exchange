package com.xr.exchange.dao;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.model.AdminBean;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
public interface AdminDao {

    List<AdminBean> getAllAdmin(AdminListBean adminListBean);
    void saveAdmin(AdminBean adminBean);
    int getCountAdmin(AdminBean adminBean);
}
