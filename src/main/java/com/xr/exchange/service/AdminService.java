package com.xr.exchange.service;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.ProxyPayListBean;
import com.xr.exchange.bean.ProxyPopListBean;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.ProxyPopVo;
import com.xr.exchange.model.UserPopVo;

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
    Map<String, Object> getAllAdmin(AdminListBean adminListBean, Integer showLevel, AdminBean loginAdmin);

    /**
     * 保存
     * @param adminBean
     */
    void saveAdmin(AdminBean adminBean,AdminBean loginAdmin) throws Exception;
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

    /**
     * 更新用户状态
     * @param username
     * @param status
     */
    void updateStatus(String username, String status);

    /**
     * 删除管理员
     * @param username
     */
    void delete(String username);

    /**
     * 查询管理员
     * @param id
     * @return
     */
    AdminBean getAdmin(Integer id);

    /**
     * 修改管理员信息
     * @param adminBean
     */
    void updateAdmin(AdminBean adminBean);
    /**
     * 修改密码
     * @param adminBean
     */
    Integer upPassword(String oldpassword, String password, int id);

    /**
     * 代理入金列表
     * @param proxyPayListBean
     * @param loginAdmin
     * @return
     */
    Map<String, Object> getProxyPayList(ProxyPayListBean proxyPayListBean, AdminBean loginAdmin);

    /**
     * 代理出金列表
     * @param proxyPopListBean
     * @param loginAdmin
     * @return
     */
    Map<String, Object> getProxyPopList(ProxyPopListBean proxyPopListBean, AdminBean loginAdmin);

    /**
     * 代理出金驳回
     * @param proxyPopVo
     * @return
     */
    Boolean rebutPop(ProxyPopVo proxyPopVo);
    /**
     * 代理出金同意
     * @param proxyPopVo
     * @return
     */
    Boolean agreePop(ProxyPopVo proxyPopVo);
}
