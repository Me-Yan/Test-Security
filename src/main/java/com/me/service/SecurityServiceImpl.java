package com.me.service;

import com.me.dto.BaseUserDetails;
import com.me.dto.LoginHistoryDTO;
import com.me.dto.ResourceDTO;
import com.me.dto.RoleDTO;
import com.me.mapper.SecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Me on 2018/8/18.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    public BaseUserDetails getUserByUsername(String username) {
        BaseUserDetails user = securityMapper.getUserByUsername(username);
        if (null != user) {
            ResourceDTO homeResource = securityMapper.getHomePageByUsername(username);
            if (null != homeResource) {
                user.setHomePage(homeResource.getResourcePath());
            }

            List<RoleDTO> roleList = securityMapper.listRoleByUsername(username);

            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            if (null != roleList && !roleList.isEmpty()) {
                for (RoleDTO role : roleList) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                    authorities.add(authority);
                }
            }

            user.setAuthorities(authorities);
        }

        return user;
    }

    public void saveLoginHistory(LoginHistoryDTO loginHistory) {
        securityMapper.saveLoginHistory(loginHistory);
    }
}
