package com.xr.exchange.configuration;

import com.xr.exchange.constants.Const;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆切面
 *
 * @author Administrator
 * @create 2018/3/24.
 */
@Component
@Aspect
public class LoginAspect {

    @Pointcut("within(com.xr.exchange.controller..Admin*) && !within(com.xr.exchange.controller.AdminIndexController)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Object loginAdmin = session.getAttribute(Const.KEY_SESSION_LOGIN_ADMIN);
        if (loginAdmin == null) {
            return "redirect:/admin";
        }

        return joinPoint.proceed();
    }

}
