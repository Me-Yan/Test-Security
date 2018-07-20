package com.me.provider;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by yanyanghong on 2018/7/20.
 */
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {


    private UserDetailsService userDetailsService;

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        if (null==authentication.getCredentials()) {
            throw new BadCredentialsException("Bad Credentials: " + userDetails);
        }

        if (!userDetails.getPassword().equals(authentication.getCredentials().toString())) {
            throw new BadCredentialsException("password not matched :" + userDetails.toString());
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (null==userDetails) {
            throw new AuthenticationCredentialsNotFoundException("not found the user :" + username);
        }
        return userDetails;
    }
}
