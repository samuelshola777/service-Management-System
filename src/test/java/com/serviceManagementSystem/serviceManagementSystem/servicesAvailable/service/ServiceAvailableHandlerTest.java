package com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service;

import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.dtos.ServiceDto;
import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.models.ServiceProvided;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ServiceAvailableHandlerTest {
    private ServiceDto serviceDto;
    private ServiceDto serviceDto2;
   @Autowired
    private ServiceAvailableHandler serviceAvailableHandler;

    @BeforeEach
    void setUp() {
        serviceDto = new ServiceDto();
        serviceDto.setCost(7093.3);
        serviceDto.setName("laudary servic");
        serviceDto.setDescription("the laudary service clean your environment");
        serviceDto.setEstimatedDurationInDays(5);

        serviceDto2 = new ServiceDto();
        serviceDto2.setCost(7023.3);
        serviceDto2.setName("transport service");
        serviceDto2.setDescription("the ltransport service clean your house");
        serviceDto2.setEstimatedDurationInDays(53);

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

        List<ServiceProvided> listOfService = serviceAvailableHandler.findAll();
    }

    @Test
    void updateService() {
        ServiceDto updateService = new ServiceDto();
        updateService.setDescription("the transport is no free");
        updateService.setId( 2);
        serviceAvailableHandler.updateService(updateService);

    }

    @Test
    void deleteService() {

    }

    @Test
    void getServiceById() {
        ServiceDto response = serviceAvailableHandler.findService(2);
        assertNotNull(response);
    }
}