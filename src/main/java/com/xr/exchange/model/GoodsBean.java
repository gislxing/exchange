package com.xr.exchange.model;

/**
 * 商品bean
 *
 * @author Administrator
 * @create 2018/3/29.
 */
public class GoodsBean {

    private Integer id;
    private String name;
    private String data_path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData_path() {
        return data_path;
    }

    public void setData_path(String data_path) {
        this.data_path = data_path;
    }
}
