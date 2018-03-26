package com.xr.exchange.controller;

import com.xr.exchange.bean.AdminListBean;
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


}
