package com.xr.exchange.controller;

import com.xr.exchange.constants.Const;
import com.xr.exchange.model.AdminBean;
import com.xr.exchange.service.AdminService;
import com.xr.exchange.utils.IpUtils;
import com.xr.exchange.utils.VerifyUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Date;
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
public class AdminIndexController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AdminService adminService;

    /**
     * 默认登录页面
     * @return
     */
    @GetMapping(value = "")
    public String login(HttpSession session,Map<String, Object> map){
        AdminBean adminBean = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
        if(adminBean !=null){
            return index(session,map);
        }else {
            return "admin/login";
        }

    }

    /**
     * 获取验证码
     * @param response
     * @param session
     * @throws Exception
     */
    @GetMapping("/valicode")
    public void valicode(HttpServletResponse response, HttpSession session) throws Exception{
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("imageCode",objs[0]);

        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

    /**
     * 登录
     * @param
     * @param session
     * @param imageCode
     * @param adminBean
     * @return
     * @throws Exception
     */
    @PostMapping("/loginAdmin")
    @ResponseBody
    public Map<String, Object> checkValiCode(HttpServletRequest request, HttpSession session, String imageCode, AdminBean adminBean) throws Exception{
        Map<String,Object> map = new HashMap<>();
        String code = (String)session.getAttribute("imageCode");
        String msg = "";
        String flag = "";
        if(!code.toLowerCase().equals(imageCode.toLowerCase())){
            flag = "failed";
            msg = "验证码错误！";
        }else {
            try {
                adminBean.setPassword(DigestUtils.md5Hex(adminBean.getPassword()));
                AdminBean adminBeanSession = adminService.loginAdmin(adminBean);
                if (adminBeanSession!=null){
                    AdminBean adminBean1 = new AdminBean();
                    adminBean1.setLastLoginIp(request.getLocalAddr());
                     adminBean1.setLastLoginTime(new Date());
                    adminBean1.setId(adminBeanSession.getId());
                    adminService.updateAdmin(adminBean1);
                    session.setAttribute(Const.KEY_SESSION_LOGIN_ADMIN,adminBeanSession);
                    flag = "success";
                    msg = "登录成功！";
                }else {
                    flag = "failed";
                    msg = "用户名或密码错误！";
                }

            }catch (Exception ex){
                log.error("登录失败", ex);
                flag = "failed";
                msg = "登录失败！";
            }
        }

        map.put("msg",msg);
        map.put("flag",flag);
        return map;
    }

    @GetMapping("/index")
    public String index(HttpSession session, Map<String, Object> map){
        AdminBean adminBean = (AdminBean) session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
        map.put(Const.SIGN_LOGIN_ADMIN_LEVEL, adminBean.getLevel());
        map.put(Const.SIGN_ADMIN_SHOW_LEVEL, adminBean.getShowLevel());
        map.put(Const.LOGIN_ADMIN_NAME, adminBean.getUsername());
        return "admin/index";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session, Map<String, Object> map){
        session.setAttribute(Const.KEY_SESSION_LOGIN_ADMIN,null);
        return login(session,map);
    }
}
