package com.demo.monolithic_security_security_product.service;


import com.demo.monolithic_security_security_product.entity.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class CustomUserDetails implements UserDetails {

    private String authUserName;
    private String password;
    private List<SimpleGrantedAuthority> allRoles;

    public String getAuthUserName() {
        return authUserName;
    }

    public void setAuthUserName(String authUserName) {
        this.authUserName = authUserName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SimpleGrantedAuthority> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<SimpleGrantedAuthority> allRoles) {
        this.allRoles = allRoles;
    }

    public CustomUserDetails(String authUserName, String password, List<Roles> allRoles) {
        this.authUserName = authUserName;
        this.password = password;
        this.allRoles = allRoles.stream().map((role) -> new SimpleGrantedAuthority(role.getRoleName())).toList();
    }
}
