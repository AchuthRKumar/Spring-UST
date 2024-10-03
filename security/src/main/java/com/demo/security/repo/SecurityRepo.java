package com.demo.security.repo;

import com.demo.security.entity.SecurityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepo extends JpaRepository<SecurityData, Integer> {
}
