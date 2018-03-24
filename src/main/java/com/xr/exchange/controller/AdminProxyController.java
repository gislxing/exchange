package com.xr.exchange.controller;

import com.xr.exchange.bean.AdminListBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    /**
     * 管理员列表
     *
     * @param adminListBean
     * @param showLevel
     * @param map
     * @return
     */
    @GetMapping("/proxy/{showLevel}")
    public String adminList(AdminListBean adminListBean, @PathVariable("showLevel") Integer showLevel, HttpSession session, Map<String, Object> map) {
        AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);

        Map<String, Object> dataMap = adminService.getAllAdmin(adminListBean, showLevel, loginAdmin);
        map.put(Const.STR_DATA, dataMap.get(Const.STR_DATA));
        map.put(Const.STR_PAGE_INFO, dataMap.get(Const.STR_PAGE_INFO));
        map.put(Const.SIGN_ADMIN_SHOW_LEVEL, showLevel);
        map.put(Const.STR_SEARCH_CONDITIONS, adminListBean);
        map.put(Const.SIGN_ADMIN_LEVEL, loginAdmin.getLevel());

        return "admin/proxy-list";
    }

    /**
     * 添加管理员页面
     * @return
     */
    @GetMapping("/add")
    public String addAdmin() {
        return "admin/admin-add";
    }

    /**
     * 修改管理员
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/add/{id}")
    public String updateAdmin(@PathVariable("id") Integer id, Map<String, Object> map) {
        // 查询管理员信息
        AdminBean adminBean = adminService.getAdmin(id);
        map.put(Const.STR_DATA, adminBean);
        return "admin/admin-add";
    }

    /**
     * 保存管理员
     *
     * @param adminBean
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveAdmin(AdminBean adminBean, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        String msg;
        String flag;

        try {
            boolean isnot = adminService.checkAdmin(adminBean);
            if (!isnot) {
                msg = "用户已经存在";
                flag = Const.FAILED_FLAG;
            } else {
                AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
                setCreateAdminLevel(adminBean, loginAdmin);
                adminBean.setParentId(loginAdmin.getId());
                adminBean.setPassword(DigestUtils.md5Hex(adminBean.getPassword()));
                adminService.saveAdmin(adminBean);
                flag = Const.SUCCESS_FLAG;
                msg = "添加管理员成功";
            }
        } catch (Exception e) {
            String tmp = "添加管理员失败, " + e.getMessage();
            log.error(tmp, e);
            flag = Const.FAILED_FLAG;
            msg = tmp;
        }
        map.put(Const.STR_MSG, msg);
        map.put(Const.STR_FLAG, flag);

        return map;
    }

    /**
     * 根据当前登陆用户等级设置添加的管理员等级，上级只能添加直属下级，管理员等级从上到下是：
     * 1：交易所， 2：运营中心，3：综合会员 （微圈代理无权限添加管理员）
     *  @param adminBean
     * @param loginAdmin
     */
    private void setCreateAdminLevel(AdminBean adminBean, AdminBean loginAdmin) throws Exception {
        int loginAdminLevel = loginAdmin.getLevel();
        int createAdminLevel;

        // 交易所、运营中心、综合会员才可以添加管理员
        if (loginAdminLevel <= Const.ADMIN_LEVEL_COMPREHENSIVE_MEMBER && loginAdminLevel >= Const.ADMIN_LEVEL_EXCHANGE) {
            createAdminLevel = loginAdminLevel + 1;
        } else {
            throw new Exception("当前登陆管理员等级错误");
        }

        adminBean.setLevel(createAdminLevel);
    }

    /**
     * 修改管理员信息
     *
     * @param adminBean
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateAdmin(AdminBean adminBean) {
        Map<String, Object> map = new HashMap<>();
        String msg = "修改管理员信息成功";
        String flag;
        try {
            if (adminBean.getPassword() != null && !adminBean.getPassword().isEmpty()) {
                adminBean.setPassword(DigestUtils.md5Hex(adminBean.getPassword()));
            }

            adminService.updateAdmin(adminBean);
            flag = Const.SUCCESS_FLAG;
        } catch (Exception e) {
            log.error("修改管理员信息失败", e);
            flag = Const.FAILED_FLAG;
            msg = "修改管理员信息失败";
        }
        map.put(Const.STR_MSG, msg);
        map.put(Const.STR_FLAG, flag);

        return map;
    }

    /**
     * 禁用 or 启用管理员
     *
     * @param username
     * @param status
     * @return
     */
    @PostMapping("/able/enable")
    @ResponseBody
    public Map<String, Object> ableOrEnableAdmin(String username, String status) {
        Map<String, Object> map = new HashMap<>();
        try {
            adminService.updateStatus(username, status);
        } catch (Exception e) {
            log.error("更新管理员状态失败", e);
            map.put(Const.STR_MSG, "更新管理员状态失败: " + e.getCause());
        }

        return map;
    }

    /**
     * 删除管理员
     *
     * @param username
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteAdmin(String username) {
        Map<String, Object> map = new HashMap<>();
        try {
            adminService.delete(username);
        } catch (Exception e) {
            log.error("管理员删除失败", e);
            map.put(Const.STR_MSG, "管理员删除失败: " + e.getCause());
        }

        return map;
    }
    /**
     * 跳转修改密码页面
     *
     * @param
     * @return
     */
    @GetMapping("/password/update")
    public String passwordUpdate() {
        return "admin/password-update";
    }
    /**
     * 修改密码
     *
     * @param
     * @return
     */
    @PostMapping("/password/updatesave")
    @ResponseBody
    public Map<String, Object>  passwordUpdateSave(HttpSession session,String oldpassword,String password) {
        Map<String, Object> map = new HashMap<>();
        AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
        String msg = "";
        String flag ="";
        try {
            Integer i = adminService.upPassword(oldpassword,password,loginAdmin.getId());
            if(i == null){
                flag = Const.FAILED_FLAG;
                msg = "原始密码错误！";
            }else{
                msg = "密码修改成功";
                flag = Const.SUCCESS_FLAG;
            }
        } catch (Exception e) {
            log.error("修改管理员信息失败", e);
            flag = Const.FAILED_FLAG;
            msg = "密码修改失败！";
        }
        map.put(Const.STR_MSG, msg);
        map.put(Const.STR_FLAG, flag);

        return map;
    }
}
