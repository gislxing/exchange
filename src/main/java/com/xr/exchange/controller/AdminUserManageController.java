package com.xr.exchange.controller;

import com.xr.exchange.bean.AdminListBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 管理员-用户管理
 *
 * @author Administrator
 * @create 2018/3/26.
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserManageController {

    @GetMapping("/list")
    public String user(Map<String, Object> map, AdminListBean adminListBean){
            return null;
    }


}
