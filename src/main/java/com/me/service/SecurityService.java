package com.me.service;

import com.me.dto.BaseUserDetails;
import com.me.dto.LoginHistoryDTO;
import org.springframework.stereotype.Service;

/**
 * Created by Me on 2018/8/18.
 */
public interface SecurityService {

    BaseUserDetails getUserByUsername(String username);

    public void saveLoginHistory(LoginHistoryDTO loginHistory);
}
