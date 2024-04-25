package com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service;

import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.dtos.ServiceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ServiceAvailableHandlerTest {
    private ServiceDto serviceDto;
   @Autowired
    private ServiceAvailableHandler serviceAvailableHandler;

    @BeforeEach
    void setUp() {
        serviceDto.setCost(7093.3);
        serviceDto.setName("laudary servic");
        serviceDto.setDescription("the laudary service clean your environment");
        serviceDto.setEstimatedDurationInDays(5);

    }

    @Test
    void createService() {
        ServiceDto response = serviceAvailableHandler.createService(serviceDto);
        assertNotNull(response);

    }

    @Test
    void findService() {
        ServiceDto response = serviceAvailableHandler.findService(1);
        assertNotNull(response);
    }


    @Test
    void findAll() {
    }

    @Test
    void updateService() {
    }

    @Test
    void deleteService() {
    }

    @Test
    void getServiceById() {
    }
}