package com.xr.exchange.service;

import com.xr.exchange.model.GoodsBean;

import java.util.List;

/**
 * 管理员-商品service
 *
 * @author Administrator
 * @create 2018/3/28.
 */
public interface AdminGoodsService {

    List<GoodsBean> getAll();

}
