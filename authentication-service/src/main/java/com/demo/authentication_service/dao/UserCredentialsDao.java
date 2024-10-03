package com.demo.authentication_service.dao;

import com.demo.authentication_service.entity.UserCredentialsEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentialsEntity, Integer> {
    public UserCredentialsEntity findByName(String name);
}
