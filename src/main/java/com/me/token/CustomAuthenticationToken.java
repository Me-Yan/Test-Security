package com.me.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by Me on 2018/8/18.
 */
public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private List<GrantedAuthority> authorities;
    private Object principal;
    private String credentials;
    private Boolean authenticated = false;
    private String name;

    public CustomAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public void setPrincipal(Object principal) {
        this.principal = principal;
    }

    @Override
    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}