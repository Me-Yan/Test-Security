package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yanyanghong on 2018/7/12.
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public ModelAndView loginPage() {

        return new ModelAndView("login");
    }


}
