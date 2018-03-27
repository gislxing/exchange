package com.xr.exchange.controller;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.bean.UserPayListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.model.UserListBean;
import com.xr.exchange.service.AdminUserManageService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserManageService adminUserManageService;

    /**
     * 用户列表
     * @param map
     * @param adminListBean
     * @param session
     * @return
     */
    @GetMapping("/list")
    public String user(Map<String, Object> map, AdminListBean adminListBean, HttpSession session) {
        AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);

        Map<String, Object> dataMap = adminUserManageService.getUsers(adminListBean, loginAdmin);
        map.put(Const.STR_DATA, dataMap.get(Const.STR_DATA));
        map.put(Const.STR_PAGE_INFO, dataMap.get(Const.STR_PAGE_INFO));
        map.put(Const.STR_SEARCH_CONDITIONS, adminListBean);
        map.put(Const.SIGN_ADMIN_LEVEL, loginAdmin.getLevel());

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
    @GetMapping("/userPayList")
    public String adminList(UserPayListBean userPayListBean, HttpSession session, Map<String, Object> map) {
        AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
        Map<String, Object> dataMap = adminUserManageService.getUserPayList(userPayListBean,loginAdmin);
        map.put(Const.STR_DATA, dataMap.get(Const.STR_DATA));
        map.put(Const.STR_PAGE_INFO, dataMap.get(Const.STR_PAGE_INFO));
        map.put(Const.STR_SEARCH_CONDITIONS, userPayListBean);
        return "admin/userPayList";
    }

    /**
     * 修改用户信息
     * @param userListBean
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateUser(UserListBean userListBean) {
        Integer count = adminUserManageService.updateUser(userListBean);
        String msg;
        if (count >= 1){
            msg = "操作成功";
        }else{
            msg = "操作失败";
        }

        Map<String, Object> map = new HashMap<>();
        map.put(Const.STR_MSG, msg);
        map.put(Const.STR_FLAG, String.valueOf(count));
        return map;
    }

    /**
     * 重置用户密码
     * @param userListBean
     * @return
     */
    @PostMapping("/reset/password")
    @ResponseBody
    public Map<String, Object> resetPassword(UserListBean userListBean) {
        userListBean.setPassword(DigestUtils.md5Hex(Const.DEFAULT_PASSWORD));
        Integer updateCount = adminUserManageService.updateUser(userListBean);
        String msg;
        if (updateCount == 0){
            msg = "密码重置失败";
        }else{
            msg = "密码重置成功";
        }

        Map<String, Object> map = new HashMap<>();
        map.put(Const.STR_MSG, msg);
        map.put(Const.STR_FLAG, String.valueOf(updateCount));
        return map;
    }

}
