package com.xr.exchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping(value = "")
    public String index(){
        return "admin/index";
    }

}
