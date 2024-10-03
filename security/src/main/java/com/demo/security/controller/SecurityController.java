package com.demo.security.controller;

import com.demo.security.entity.SecurityData;
import com.demo.security.repo.SecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecurityController {

    SecurityRepo securityRepo;

    @Autowired
    public SecurityController(SecurityRepo securityRepo) {
        this.securityRepo = securityRepo;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "This is not secure";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userProfile(){
        return "This is user profile";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminProfile(){
        return "This is admin profile";
    }

    @PostMapping("/admin/data")
    @PreAuthorize("hasRole('ADMIN')")
    public SecurityData addUser(@RequestBody SecurityData sd){
        return securityRepo.save(sd);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('USER')")
    public SecurityData getUser(@PathVariable int id){
        return securityRepo.findById(id).orElse(null);
    }
}
