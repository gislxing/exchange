package com.xr.exchange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.ProxyPayListBean;
import com.xr.exchange.bean.ProxyPopListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.dao.AdminDao;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.ProxyPayVo;
import com.xr.exchange.model.ProxyPopVo;
import com.xr.exchange.service.AdminService;
import com.xr.exchange.utils.PageUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminDao adminDao;

    /**
     * 获取用户列表
     *
     * @param adminListBean
     * @return
     */
    @Override
    public Map<String, Object> getAllAdmin(AdminListBean adminListBean, Integer showLevel, AdminBean loginAdmin) {
        PageHelper.startPage(adminListBean.getPageNum(), adminListBean.getPageSize());
        List<AdminBean> list = adminDao.getAllAdmin(adminListBean, showLevel, loginAdmin);
        return PageUtil.getPageData(list);
    }

    /**
     * 保存用户
     *
     * @param adminBean
     */
    @Override
    public void saveAdmin(AdminBean adminBean, AdminBean loginAdmin) throws Exception {
        adminBean.setStatus(1);
        adminBean.setAddTime(new Date());
        adminBean.setMoney(0.00);
        adminDao.saveAdmin(adminBean);

        adminDao.upateKeyId(loginAdmin, adminBean.getId());
    }

    /**
     * 验证用户名是否重复
     *
     * @param adminBean
     * @return
     */
    @Override
    public boolean checkAdmin(AdminBean adminBean) {
        int count = adminDao.getCountAdmin(adminBean);
        return count > 0 ? false : true;
    }

    /**
     * 登录
     *
     * @param adminBean
     * @return
     */
    @Override
    public AdminBean loginAdmin(AdminBean adminBean) {
        AdminBean adminBeanSession = adminDao.getCountAdminLogin(adminBean);
        return adminBeanSession;
    }

    @Override
    public void updateStatus(String username, String status) {
        if (username == null || username.isEmpty()) {
            return;
        }

        if (status == null || status.isEmpty()) {
            return;
        }

        adminDao.upateStatus(username, status);
    }

    @Override
    public void delete(String username) {
        if (username == null || username.isEmpty()) {
            return;
        }

        adminDao.delete(username);
    }

    @Override
    public AdminBean getAdmin(Integer id) {
        if (id == null) {
            return null;
        }

        return adminDao.getAdmin(id);
    }

    @Override
    public void updateAdmin(AdminBean adminBean) {
        if (adminBean == null) {
            return;
        }

        adminDao.updateAdmin(adminBean);
    }

    @Override
    public Integer upPassword(String oldpassword, String password, int id) {
        oldpassword = DigestUtils.md5Hex(oldpassword);
        password = DigestUtils.md5Hex(password);
        return adminDao.upPassword(oldpassword, password, id);
    }

    @Override
    public Map<String, Object> getProxyPayList(ProxyPayListBean proxyPayListBean, AdminBean loginAdmin) {
        PageHelper.startPage(proxyPayListBean.getPageNum(), proxyPayListBean.getPageSize());
        List<ProxyPayVo> list = adminDao.getProxyPayList(proxyPayListBean, loginAdmin);
        return PageUtil.getPageData(list);
    }

    @Override
    public Map<String, Object> getProxyPopList(ProxyPopListBean proxyPopListBean, AdminBean loginAdmin) {
        PageHelper.startPage(proxyPopListBean.getPageNum(), proxyPopListBean.getPageSize());
        List<ProxyPopVo> list = adminDao.getProxyPopList(proxyPopListBean, loginAdmin);
        return PageUtil.getPageData(list);
    }

    @Override
    public Boolean rebutPop(ProxyPopVo proxyPopVo) {
        Boolean ret = true;
        try {
            adminDao.rebutPop(proxyPopVo);
            adminDao.updateAdminMoney(proxyPopVo.getAdminId(), proxyPopVo.getPopMoney());
        } catch (Exception ex) {
            ret = false;
            log.error(ex.toString());
        }
        return ret;
    }

    @Override
    public Boolean agreePop(ProxyPopVo proxyPopVo) {
        Boolean ret = true;
        try {
            adminDao.rebutPop(proxyPopVo);
        } catch (Exception ex) {
            ret = false;
            log.error(ex.toString());
        }
        return ret;
    }
}
