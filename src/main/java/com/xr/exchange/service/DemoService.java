package com.xr.exchange.service;

import com.xr.exchange.model.Demo;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
public interface DemoService {

    List<Demo> getAllUser(Integer pageNum, Integer pageSize);

}
