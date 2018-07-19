package com.me.mapper;

import com.me.dto.UserDTO;

/**
 * Created by yanyanghong on 2018/7/19.
 */
public interface SecurityMapper {

    UserDTO getUserByUsername(String username);

}
