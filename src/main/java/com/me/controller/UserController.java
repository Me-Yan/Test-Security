package com.me.controller;

import com.me.dto.UserDetailsDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yanyanghong on 2018/7/12.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("info")
    public ModelAndView userInfo(@ModelAttribute("userForm") UserDetailsDTO userForm) {

        return new ModelAndView("userInfo");
    }

    @RequestMapping("introduction")
    public ModelAndView introduction() {

        return new ModelAndView("introduction");
    }

    @RequestMapping("low")
    public ModelAndView low() {

        return new ModelAndView("low");
    }

    @RequestMapping("middle")
    public ModelAndView middle() {

        return new ModelAndView("middle");
    }

    @RequestMapping("high")
    public ModelAndView high() {

        return new ModelAndView("high");
    }
}
