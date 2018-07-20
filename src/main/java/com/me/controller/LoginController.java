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
public class LoginController {

    @RequestMapping("login")
    public ModelAndView loginPage(@ModelAttribute("userForm")UserDetailsDTO userDTO) {

        return new ModelAndView("login");
    }


}
