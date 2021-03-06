package com.me.provider;

import com.me.token.CustomAuthenticationToken;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * Created by Me on 2018/8/18.
 */
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        if (StringUtils.isBlank(userDetails.getPassword())) {
            throw new BadCredentialsException("password is empty.");
        }

        String password = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("password is incorrect and does not match");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(username);
    }

    @Override
    protected Authentication createSuccessAuthentication(Object principal,
                                                         Authentication authentication, UserDetails user) {

        CustomAuthenticationToken result = new CustomAuthenticationToken(principal, authentication.getCredentials());
        result.setAuthorities((List<GrantedAuthority>) user.getAuthorities());
        result.setAuthenticated(Boolean.TRUE);
        result.setPrincipal(user);
        result.setName(user.getUsername());
        result.setCredentials(authentication.getCredentials().toString());

        return result;
    }

    public boolean supports(Class<?> authentication) {
        return (CustomAuthenticationToken.class
                .isAssignableFrom(authentication));
    }

    public BCryptPasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
