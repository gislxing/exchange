package com.xr.exchange.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xr.exchange.dao.DemoDao;
import com.xr.exchange.model.Demo;
import com.xr.exchange.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
@Service
public class DemoServiceImpl implements DemoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoDao demoDao;

    /**
     *
     * 只需要在service层传入参数，然后将参数传递给分页插件的一个静态方法即可实现分页
     *
     * @param pageNum
     *      页码
     * @param pageSize
     *      每页显示的数量
     * @return
     */
    @Override
    public List<Demo> getAllUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Demo> list = demoDao.getAllUser();
        // 分页信息包括总页数，当前页，总数据等
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }
}
