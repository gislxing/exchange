package com.xr.exchange.controller;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.model.UserBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.model.AdminBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String user(Map<String, Object> map, AdminListBean adminListBean, HttpSession session) {
        AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);

        return "admin/user-list";
    }

    /**
     * 客户入金明细列表
     *
     * @param
     * @param
     * @param map
     * @return
     */
    @GetMapping("/userPopList")
    public String adminList(UserBean userBean, HttpSession session, Map<String, Object> map) {
        //AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
/*
        Map<String, Object> dataMap = adminService.getAllAdmin(adminListBean, showLevel, loginAdmin);
        map.put(Const.STR_DATA, dataMap.get(Const.STR_DATA));
        map.put(Const.STR_PAGE_INFO, dataMap.get(Const.STR_PAGE_INFO));
        map.put(Const.SIGN_ADMIN_SHOW_LEVEL, showLevel);
        map.put(Const.STR_SEARCH_CONDITIONS, adminListBean);
        map.put(Const.SIGN_ADMIN_LEVEL, loginAdmin.getLevel());*/

        return "admin/userPopList";
    }
}
