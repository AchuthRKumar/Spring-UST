package com.demo.monolithic_security_security_product.service;

import com.demo.monolithic_security_security_product.dao.ProductDao;
import com.demo.monolithic_security_security_product.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao pd;

    public ProductService(ProductDao pd) {

        this.pd = pd;
    }

    public List<ProductEntity> getAllProducts(){
        return pd.findAll();
    }

    public ProductEntity getAProduct(int prodId){
        return pd.findById(prodId).orElse(null);
    }

    public ProductEntity addProduct(ProductEntity pe){
        return pd.save(pe);
    }
}
