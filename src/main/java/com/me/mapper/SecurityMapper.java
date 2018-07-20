package com.me.mapper;

import com.me.dto.UserDetailsDTO;

import java.util.List;

/**
 * Created by yanyanghong on 2018/7/19.
 */
public interface SecurityMapper {

    UserDetailsDTO getUserByUsername(String username);

    String getHomePage(String username);

    List<String> listRole(String username);

}
