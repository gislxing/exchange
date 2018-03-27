package com.xr.exchange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.dao.AdminUserManageDao;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.UserPayVo;
import com.xr.exchange.service.AdminUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/26.
 */
@Service
public class AdminUserManageServiceImpl implements AdminUserManageService{
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
}
