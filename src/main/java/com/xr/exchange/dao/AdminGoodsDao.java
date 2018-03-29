package com.xr.exchange.dao;

import com.xr.exchange.model.GoodsBean;

import java.util.List;

/**
 * 管理员-商品dao
 *
 * @author Administrator
 * @create 2018/3/28.
 */
public interface AdminGoodsDao {

    List<GoodsBean> getAll();
}
