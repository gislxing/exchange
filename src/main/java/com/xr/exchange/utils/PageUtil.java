package com.xr.exchange.utils;

import com.github.pagehelper.PageInfo;
import com.xr.exchange.constants.Const;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sevice 帮助类
 *
 * @author Administrator
 * @create 2018/3/28.
 */
public class PageUtil {

    /**
     * 封装分页数据
     * @param list
     *      要封装的数据列表
     * @return
     */
    public static Map<String, Object> getPageData(List<?> list){
        // 分页信息包括总页数，当前页，总数据等
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> map = new HashMap<>();
        map.put(Const.STR_DATA, list);
        map.put(Const.STR_PAGE_INFO, pageInfo);
        return map;
    }

}
