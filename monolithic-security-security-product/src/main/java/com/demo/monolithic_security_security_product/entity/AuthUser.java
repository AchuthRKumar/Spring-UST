package com.demo.monolithic_security_security_product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="user_details_table")
public class AuthUser {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="authUser_id")
    private int authUserId;
    @Column(name="authUser_name")
    private String authUserName;
    @Column(name="password")
    private String password;

    @ManyToMany
    @JoinTable(name = "authUser_roles", joinColumns = @JoinColumn(name = "authUser_id"),
                        inverseJoinColumns = @JoinColumn(name = "role_id"))

    List<Roles> allRoles;

    public AuthUser(List<Roles> allRoles, String password, String authUserName, int authUserId) {

        this.allRoles = allRoles;
        this.password = password;
        this.authUserName = authUserName;
        this.authUserId = authUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthUserName() {
        return authUserName;
    }

    public void setAuthUserName(String authUserName) {
        this.authUserName = authUserName;
    }

    public int getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(int authUserId) {
        this.authUserId = authUserId;
    }

    public List<Roles> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<Roles> allRoles) {
        this.allRoles = allRoles;
    }
}

