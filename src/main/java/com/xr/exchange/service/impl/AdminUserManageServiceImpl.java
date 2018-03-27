package com.xr.exchange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.dao.AdminUserManageDao;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.UserBean;
import com.xr.exchange.model.UserListBean;
import com.xr.exchange.model.UserPayVo;
import com.xr.exchange.service.AdminUserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员-用户列表
 *
 * @author Administrator
 * @create 2018/3/26.
 */
@Service
public class AdminUserManageServiceImpl implements AdminUserManageService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserManageDao adminUserManageDao;

    @Override
    public Map<String, Object> getUserPayList(UserPayListBean userPayListBean, AdminBean loginAdmin) {
        PageHelper.startPage(userPayListBean.getPageNum(), userPayListBean.getPageSize());
        List<UserPayVo> list = adminUserManageDao.getUserPayList(userPayListBean,loginAdmin);

        // 分页信息包括总页数，当前页，总数据等
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map = new HashMap<>();
        map.put(Const.STR_DATA,list);
        map.put(Const.STR_PAGE_INFO,pageInfo);
        return map;
    }

    /**
     * 查询用户列表信息
     * @param adminListBean
     * @param loginAdmin
     * @return
     */
    @Override
    public Map<String, Object> getUsers(AdminListBean adminListBean, AdminBean loginAdmin) {
        PageHelper.startPage(adminListBean.getPageNum(), adminListBean.getPageSize());
        List<UserBean> list = adminUserManageDao.getUsers(adminListBean, loginAdmin);

        // 分页信息包括总页数，当前页，总数据等
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> map = new HashMap<>();
        map.put(Const.STR_DATA, list);
        map.put(Const.STR_PAGE_INFO, pageInfo);
        return map;
    }

    /**
     * 修改用户信息
     * @param userListBean
     * @return
     */
    @Override
    public Integer updateUser(UserListBean userListBean) {
        if (userListBean == null || userListBean.getId() == null){
            return 0;
        }

        return adminUserManageDao.updateUser(userListBean);
    }
}
