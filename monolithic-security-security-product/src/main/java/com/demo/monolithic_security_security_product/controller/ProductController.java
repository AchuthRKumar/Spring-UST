package com.demo.monolithic_security_security_product.controller;

import com.demo.monolithic_security_security_product.entity.ProductEntity;
import com.demo.monolithic_security_security_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    ProductService ps;
    @Autowired

    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        return ps.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductEntity getAProduct(@PathVariable int prodId){
        return ps.getAProduct(prodId);
    }


    @PreAuthorize("hasAuthority('ROLE_user')")
    @PostMapping("/products")
    public ProductEntity addProduct(@RequestBody ProductEntity pe){
        return ps.addProduct(pe);
    }
}

