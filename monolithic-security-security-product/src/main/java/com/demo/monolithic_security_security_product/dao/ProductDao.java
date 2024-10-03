package com.demo.monolithic_security_security_product.dao;

import com.demo.monolithic_security_security_product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductEntity, Integer> {
}
