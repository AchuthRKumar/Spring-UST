package com.demo.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
   CustomerRepository custRepo;

    @Autowired
    public CustomerController(CustomerRepository custRepo) {
        this.custRepo = custRepo;
    }

    @GetMapping("/customers")
    public List<CustomerEntity> getAllCustomer(){
        List<CustomerEntity> cAll= custRepo.findAll();
        return cAll;
    }

    @PostMapping("/customers")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity newC){
        CustomerEntity cc =custRepo.save(newC);
        return cc;
    }
}
