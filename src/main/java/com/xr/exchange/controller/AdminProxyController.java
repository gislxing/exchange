package com.xr.exchange.controller;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminProxyController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminService adminService;

    @GetMapping("/proxy")
    public String adminList(AdminListBean adminListBean, Map<String, Object> map) {
        Map<String, Object> dataMap = adminService.getAllAdmin(adminListBean);
        map.put(Const.STR_DATA, dataMap.get(Const.STR_DATA));
        map.put(Const.STR_PAGE_INFO, dataMap.get(Const.STR_PAGE_INFO));
        map.put(Const.STR_SEARCH_CONDITIONS, adminListBean);

        return "admin/proxy-list";
    }

    @GetMapping("/add")
    public String addAdmin(){
        return "admin/admin-add";
    }
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveAdmin(AdminBean adminBean){
        Map<String,Object> map = new HashMap<>();
        String msg = "";
        String flag;
        try {
            boolean isnot = adminService.checkAdmin(adminBean);
            if(!isnot){
                msg = "用户已经存在";
                flag = "failed";
            }else{
                adminService.saveAdmin(adminBean);
                flag = "success";
            }
        }catch (Exception e){
            log.error("添加管理员失败", e);
            flag = "failed";
        }
        map.put("msg", msg);
        map.put("flag", flag);

        return map;
    }
}
