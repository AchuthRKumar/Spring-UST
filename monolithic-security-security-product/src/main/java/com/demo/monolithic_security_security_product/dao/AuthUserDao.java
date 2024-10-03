package com.demo.monolithic_security_security_product.dao;

import com.demo.monolithic_security_security_product.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserDao extends JpaRepository<AuthUser, Integer > {
    AuthUser findByauthUserName(String authUserName);
}
