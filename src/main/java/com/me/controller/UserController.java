package com.me.controller;

import com.me.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by yanyanghong on 2018/7/12.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("info")
    public ModelAndView userInfo(@ModelAttribute("userForm") UserDTO userForm) {

        return new ModelAndView("userInfo");
    }
}
