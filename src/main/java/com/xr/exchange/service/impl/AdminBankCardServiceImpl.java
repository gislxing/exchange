package com.xr.exchange.service.impl;

import com.github.pagehelper.PageHelper;
import com.xr.exchange.bean.AdminBankCardParamBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.dao.AdminBankCardDao;
import com.xr.exchange.model.AdminBankCardBean;
import com.xr.exchange.service.AdminBankCardService;
import com.xr.exchange.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 银行卡service实现类
 *
 * @author Administrator
 * @create 2018/3/29.
 */
@Service
public class AdminBankCardServiceImpl implements AdminBankCardService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminBankCardDao adminBankCardDao;

    @Override
    public Map<String, Object> getAll(AdminBankCardParamBean adminBankCardParamBean) {
        PageHelper.startPage(adminBankCardParamBean.getPageNum(), adminBankCardParamBean.getPageSize());
        List<AdminBankCardBean> list = adminBankCardDao.getAll(adminBankCardParamBean.getLoginAdminId());
        return PageUtil.getPageData(list);
    }

    @Override
    public boolean updateStatus(AdminBankCardParamBean adminBankCardParamBean) {
        int count = adminBankCardDao.updateStatus(adminBankCardParamBean.getBankCardid(), adminBankCardParamBean.getStatus());
        if (count > 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        int count = adminBankCardDao.delete(id);
        if (count > 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean save(AdminBankCardBean adminBankCardBean) {
        int count = adminBankCardDao.save(adminBankCardBean);
        if (count > 0){
            return true;
        }

        return false;
    }

}
