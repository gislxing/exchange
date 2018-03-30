package com.xr.exchange.controller;

import com.xr.exchange.bean.AdminBankCardParamBean;
import com.xr.exchange.constants.Const;
import com.xr.exchange.model.AdminBankCardBean;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.service.AdminBankCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员-我的资金管理
 *
 * @author Administrator
 * @create 2018/3/29.
 */
@Controller
@RequestMapping("/admin/my")
public class AdminMyCapitalController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminBankCardService adminBankCardService;

    /**
     * 个人银行卡列表
     * @param adminBankCardParamBean
     * @param session
     * @param map
     * @return
     */
    @GetMapping("/bank/card")
    public String bankCardList(AdminBankCardParamBean adminBankCardParamBean, HttpSession session, Map<String, Object> map) {
        AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
        adminBankCardParamBean.setLoginAdminId(loginAdmin.getId());

        // 查询所有管理员银行卡信息
        Map<String, Object> dataMap = adminBankCardService.getAll(adminBankCardParamBean);
        map.putAll(dataMap);

        return "admin/bank-card";
    }

    /**
     * 绑定银行卡
     * @return
     */
    @GetMapping("/bank/card/bind")
    public String bindBankCard(){
        return "admin/bind-bank-card";
    }

    @PostMapping("/bank/card/save")
    @ResponseBody
    public Map<String, Object> saveBankCard(AdminBankCardBean adminBankCardBean, HttpSession session){
        AdminBean loginAdmin = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
        adminBankCardBean.setAdminId(loginAdmin.getId());

        boolean isSuccess = adminBankCardService.save(adminBankCardBean);
        String flag = Const.SUCCESS_FLAG;
        String msg = "操作成功";
        if (!isSuccess) {
            flag = Const.FAILED_FLAG;
            msg = "操作失败";
        }

        Map<String, Object> map = new HashMap<>();
        map.put(Const.STR_FLAG, flag);
        map.put(Const.STR_MSG, msg);
        return map;
    }

    /**
     * 删除银行卡
     * @param adminBankCardParamBean
     * @return
     */
    @PostMapping("/bank/card/delete")
    @ResponseBody
    public Map<String, Object> deleteBankCard(AdminBankCardParamBean adminBankCardParamBean){
        boolean isSuccess = adminBankCardService.delete(adminBankCardParamBean.getBankCardid());
        String flag = Const.SUCCESS_FLAG;
        String msg = "操作成功";
        if (!isSuccess) {
            flag = Const.FAILED_FLAG;
            msg = "操作失败";
        }

        Map<String, Object> map = new HashMap<>();
        map.put(Const.STR_FLAG, flag);
        map.put(Const.STR_MSG, msg);
        return map;
    }

    /**
     * 修改银行卡状态
     * @param adminBankCardParamBean
     * @return
     */
    @PostMapping("/bank/card/status")
    @ResponseBody
    public Map<String, Object> changeBankCardStatus(AdminBankCardParamBean adminBankCardParamBean){
        boolean isSuccess = adminBankCardService.updateStatus(adminBankCardParamBean);
        String flag = Const.SUCCESS_FLAG;
        String msg = "操作成功";
        if (!isSuccess) {
            flag = Const.FAILED_FLAG;
            msg = "操作失败";
        }

        Map<String, Object> map = new HashMap<>();
        map.put(Const.STR_FLAG, flag);
        map.put(Const.STR_MSG, msg);
        return map;
    }

    /**
     * 出入金列表
     * @return
     */
    @GetMapping("/capital")
    public String capitalOutIn(){
        return "admin/capital-out-in";
    }

}
