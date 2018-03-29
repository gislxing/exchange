package com.xr.exchange.service.impl;

import com.github.pagehelper.PageHelper;
import com.xr.exchange.bean.AdminUserDealBean;
import com.xr.exchange.bean.UserParamBean;
import com.xr.exchange.dao.AdminDealDao;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.UserBean;
import com.xr.exchange.service.AdminDealService;
import com.xr.exchange.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author Administrator
 * @create 2018/3/28.
 */
@Service
public class AdminDealServiceImpl implements AdminDealService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminDealDao adminDealDao;

    @Override
    public Map<String, Object> getUserDealList(UserParamBean userParamBean, AdminBean loginAdmin) {
        PageHelper.startPage(userParamBean.getPageNum(), userParamBean.getPageSize());
        List<AdminUserDealBean> list = adminDealDao.getUserDealList(userParamBean, loginAdmin);
        return PageUtil.getPageData(list);
    }

}
