package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Me on 2018/8/19.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("introduction")
    public ModelAndView introduction() {

        return new ModelAndView("introduction");
    }
}
