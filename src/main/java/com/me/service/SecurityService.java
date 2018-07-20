package com.me.service;

import com.google.common.collect.Lists;
import com.me.dto.UserDetailsDTO;
import com.me.mapper.SecurityMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanyanghong on 2018/7/20.
 */
public class SecurityService implements UserDetailsService {

    @Resource(name = "sessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SecurityMapper securityMapper = sqlSessionTemplate.getMapper(SecurityMapper.class);

        // get the user info
        UserDetailsDTO userDetailsDTO = securityMapper.getUserByUsername(username);

        // get the home page
        userDetailsDTO.setHomePage(securityMapper.getHomePage(username));

        // get the authorities
        List<String> roleList = securityMapper.listRole(username);
        if (!CollectionUtils.isEmpty(roleList)) {
            List<GrantedAuthority> authorityList = Lists.newArrayList();
            for (String role : roleList) {
                authorityList.add(new SimpleGrantedAuthority(role));
            }
            userDetailsDTO.setAuthorities(authorityList);
        }

        return userDetailsDTO;
    }
}
