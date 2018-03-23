package com.xr.exchange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.dao.AdminDao;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.service.AdminService;
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
     * @param adminListBean
     * @return
     */
    @Override
    public Map<String, Object> getAllAdmin(AdminListBean adminListBean) {
        PageHelper.startPage(adminListBean.getPageNum(), adminListBean.getPageSize());
        List<AdminBean> list = adminDao.getAllAdmin(adminListBean);
        // 分页信息包括总页数，当前页，总数据等
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map = new HashMap<>();
        map.put(Const.STR_DATA,list);
        map.put(Const.STR_PAGE_INFO,pageInfo);
        return map;
    }

    /**
     * 保存用户
     * @param adminBean
     */
    @Override
    public void saveAdmin(AdminBean adminBean) {
        adminBean.setStatus(1);
        adminBean.setAddTime(new Date());
        adminBean.setMoney(0.00);
        adminDao.saveAdmin(adminBean);
    }

    /**
     * 验证用户名是否重复
     * @param adminBean
     * @return
     */
    @Override
    public boolean checkAdmin(AdminBean adminBean) {
        int count = adminDao.getCountAdmin(adminBean);
        return  count>0?false:true;
    }

    /**
     * 登录
     * @param adminBean
     * @return
     */
    @Override
    public AdminBean loginAdmin(AdminBean adminBean) {
        AdminBean adminBeanSession = adminDao.getCountAdminLogin(adminBean);
        return  adminBeanSession;
    }
}
