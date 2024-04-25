package com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service;


import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.dtos.ServiceDto;
import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.repository.ServiceRepository;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceAvailableHandlerImpl implements ServiceAvailableHandler {

    private final ServiceRepository serviceRepository;

    @Override
    public ServiceDto createService(ServiceDto service) {
        return null;
    }

    @Override
    public ServiceDto findService(Long id) {
        return null;
    }

    @Override
    public List<ServiceDto> findAll() {
        return List.of();
    }

    @Override
    public ServiceDto updateService(ServiceDto serviceDto) {
        return null;
    }

    @Override
    public OperationResponse deleteService(Long id) {
        return null;
    }
}
