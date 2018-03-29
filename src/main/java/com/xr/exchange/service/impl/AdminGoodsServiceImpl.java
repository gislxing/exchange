package com.xr.exchange.service.impl;

import com.xr.exchange.dao.AdminGoodsDao;
import com.xr.exchange.model.GoodsBean;
import com.xr.exchange.service.AdminGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员-商品service
 *
 * @author Administrator
 * @create 2018/3/28.
 */
@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminGoodsDao adminGoodsDao;

    @Override
    public List<GoodsBean> getAll() {
        return adminGoodsDao.getAll();
    }

    // @Autowired
    // private AdminGoodsDao adminGoodsDao;
    //
    // @Override
    // public Map<String, Object> getUserDealList(UserParamBean userParamBean, AdminBean loginAdmin) {
    //     PageHelper.startPage(userParamBean.getPageNum(), userParamBean.getPageSize());
    //     List<UserBean> list = adminGoodsDao.getUserDealList(userParamBean, loginAdmin);
    //     return PageUtil.getPageData(list);
    // }

}
