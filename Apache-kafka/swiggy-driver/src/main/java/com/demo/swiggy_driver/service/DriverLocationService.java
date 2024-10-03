package com.demo.swiggy_driver.service;

import com.demo.swiggy_driver.constant.AppConstant;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverLocationService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.DRIVER_LOCATION, location);
        return true;
    }
}
