package com.xr.exchange.controller;

import com.xr.exchange.model.Demo;
import com.xr.exchange.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2018/3/20.
 */
@Controller
@RequestMapping(value = "/")
public class DemoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/user/{pageNum}/{pageSize}")
    public String getAll(Map<String, Object> map, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        log.info(String.format("查询第 %d 页数据，每页显示 %d 条数据", pageNum, pageSize));
        List<Demo> list = demoService.getAllUser(pageNum, pageSize);
        map.put("users", list);
        return "admin/index";
    }

    @GetMapping(value = "/wel")
    public String wel(){
        return "admin/welcome";
    }

}
