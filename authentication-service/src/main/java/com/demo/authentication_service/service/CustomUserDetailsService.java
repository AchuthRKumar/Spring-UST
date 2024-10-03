package com.demo.authentication_service.service;

import com.demo.authentication_service.dao.UserCredentialsDao;
import com.demo.authentication_service.entity.UserCredentialsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserCredentialsDao userCredentialsDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialsEntity user = userCredentialsDao.findByName(username);
        if(user==null){
            throw new UsernameNotFoundException(("User Not found"));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role:user.getRole()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new UserDetails(user.getName(), user.getPassword(), authorities);

    }
}

