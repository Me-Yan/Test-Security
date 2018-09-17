package com.me.controller;

import com.google.common.collect.Maps;
import com.me.dto.BaseUserDetails;
import com.me.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Me on 2018/8/19.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping("introduction")
    public ModelAndView introduction() {

        Map<String, Object> model = Maps.newHashMap();

        BaseUserDetails user = securityService.getUserByUsername("yanyanghong");

        model.put("user", user);

        return new ModelAndView("introduction", model);
    }
}
