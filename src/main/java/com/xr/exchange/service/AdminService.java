package com.xr.exchange.service;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.model.AdminBean;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
public interface AdminService {
    /**
     * 获取代理列表
     * @param adminListBean
     * @return
     */
    Map<String, Object> getAllAdmin(AdminListBean adminListBean);

    /**
     * 保存
     * @param adminBean
     */
    void saveAdmin(AdminBean adminBean);
    /**
     * 验证用户名重复
     * @param adminBean
     */
    boolean checkAdmin(AdminBean adminBean);
    /**
     * 登录验证
     * @param adminBean
     */
    AdminBean loginAdmin(AdminBean adminBean);
}
