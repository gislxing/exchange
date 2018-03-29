package com.xr.exchange.service.impl;

import com.github.pagehelper.PageHelper;
import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.bean.UserPopListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.dao.AdminDao;
import com.xr.exchange.dao.AdminUserManageDao;
import com.xr.exchange.model.*;
import com.xr.exchange.service.AdminUserManageService;
import com.xr.exchange.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 管理员-用户列表
 *
 * @author Administrator
 * @create 2018/3/26.
 */
@Service
public class AdminUserManageServiceImpl implements AdminUserManageService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserManageDao adminUserManageDao;

    @Override
    public Map<String, Object> getUserPayList(UserPayListBean userPayListBean, AdminBean loginAdmin) {
        PageHelper.startPage(userPayListBean.getPageNum(), userPayListBean.getPageSize());
        List<UserPayVo> list = adminUserManageDao.getUserPayList(userPayListBean, loginAdmin);
        return PageUtil.getPageData(list);
    }

    @Override
    public Map<String, Object> getUserPopList(UserPopListBean userPopListBean, AdminBean loginAdmin) {
        PageHelper.startPage(userPopListBean.getPageNum(), userPopListBean.getPageSize());
        List<UserPopVo> list = adminUserManageDao.getUserPopList(userPopListBean,loginAdmin);
        return PageUtil.getPageData(list);
    }

    @Override
    public Boolean rebutPop(UserPopVo userPopVo) {
        Boolean ret = true;
        try {
            adminUserManageDao.rebutPop(userPopVo);
            adminUserManageDao.updateUserMoney(userPopVo.getUserId(),userPopVo.getPopMoney());
        }catch (Exception ex){
            ret = false;
            log.error(ex.toString());
        }
        return ret;
    }

    /**
     * 查询用户列表信息
     *
     * @param adminListBean
     * @param loginAdmin
     * @return
     */
    @Override
    public Map<String, Object> getUsers(AdminListBean adminListBean, AdminBean loginAdmin) {
        PageHelper.startPage(adminListBean.getPageNum(), adminListBean.getPageSize());
        List<UserBean> list = adminUserManageDao.getUsers(adminListBean, loginAdmin);
        return PageUtil.getPageData(list);
    }

    /**
     * 修改用户信息
     *
     * @param userListBean
     * @return
     */
    @Override
    public Integer updateUser(UserListBean userListBean) {
        if (userListBean == null || userListBean.getId() == null) {
            return 0;
        }

        return adminUserManageDao.updateUser(userListBean);
    }

}
