package com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service;

import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.dtos.ServiceDto;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;

import java.util.List;

public interface ServiceAvailableHandler {

    ServiceDto createService(ServiceDto service);

    ServiceDto findService(Long id);

    List<ServiceDto> findAll();

    ServiceDto updateService(ServiceDto serviceDto);

    OperationResponse deleteService(Long id);

}
