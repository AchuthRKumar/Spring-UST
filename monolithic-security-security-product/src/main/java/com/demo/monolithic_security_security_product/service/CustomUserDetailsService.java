package com.demo.monolithic_security_security_product.service;

import com.demo.monolithic_security_security_product.dao.AuthUserDao;
import com.demo.monolithic_security_security_product.entity.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    AuthUserDao auDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUser = Optional.ofNullable(auDao.findByauthUserName(username));
// but we have return UserDetails and not UserInfoEntity
        return authUser
                .map((userInfo)->new CustomUserDetails(userInfo.getAuthUserName(), userInfo.getPassword(), userInfo.getAllRoles()))
                .orElseThrow(()-> new UsernameNotFoundException(username + " not found"));
    }
}
