package com.demo.monolithic_security_security_product.controller;

import com.demo.monolithic_security_security_product.entity.AuthUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthUserController {

    @PostMapping("/authusers/validate")
    public AuthUser validate(@RequestBody AuthUser user){

        return null;
    }
}
