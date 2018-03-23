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
    public String addAdmin() {
        return "admin/admin-add";
    }

    @GetMapping("/add/{id}")
    public String updateAdmin(@PathVariable("id") Integer id, Map<String, Object> map) {
        // 查询管理员信息
        AdminBean adminBean = adminService.getAdmin(id);
        map.put(Const.STR_DATA, adminBean);
        return "admin/admin-add";
    }

    /**
     * 添加管理员
     * @param adminBean
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Map<String, Object> saveAdmin(AdminBean adminBean) {
        Map<String, Object> map = new HashMap<>();
        String msg = "";
        String flag;
        try {
            boolean isnot = adminService.checkAdmin(adminBean);
            if (!isnot) {
                msg = "用户已经存在";
                flag = "failed";
            } else {
                adminBean.setPassword(DigestUtils.md5Hex(adminBean.getPassword()));
                adminService.saveAdmin(adminBean);
                flag = "success";
                msg = "添加管理员成功";
            }
        } catch (Exception e) {
            log.error("添加管理员失败", e);
            flag = "failed";
            msg = "添加管理员失败";
        }
        map.put("msg", msg);
        map.put("flag", flag);

        return map;
    }

    /**
     * 修改管理员信息
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
        } catch (Exception e){
            log.error("更新管理员状态失败", e);
            map.put(Const.STR_MSG, "更新管理员状态失败: " + e.getCause());
        }

        return map;
    }

    /**
     * 删除管理员
     * @param username
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteAdmin(String username){
        Map<String, Object> map = new HashMap<>();
        try {
            adminService.delete(username);
        } catch (Exception e){
            log.error("管理员删除失败", e);
            map.put(Const.STR_MSG, "管理员删除失败: " + e.getCause());
        }

        return map;
    }

}
