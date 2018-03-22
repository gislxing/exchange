package com.xr.exchange.bean;

import com.xr.exchange.constants.Const;

/**
 * ${DESCRIPTION}
 *
 * @author zjw
 * @create 2018/3/22.
 */
public class BaseBean {
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        if (pageNum == null) {
            this.pageNum = Const.DEFAULT_PAGE_NUM;
        } else {
            this.pageNum = pageNum;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null) {
            this.pageNum = Const.DEFAULT_PAGE_NUM;
        } else {
            this.pageNum = pageNum;
        }
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            this.pageSize = Const.DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            this.pageSize = Const.DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }
}
