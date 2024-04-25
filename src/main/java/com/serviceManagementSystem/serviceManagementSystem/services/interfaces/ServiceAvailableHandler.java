package com.serviceManagementSystem.serviceManagementSystem.services.interfaces;

import com.serviceManagementSystem.serviceManagementSystem.data.dtos.ServiceDto;
import com.serviceManagementSystem.serviceManagementSystem.data.models.ServiceProvided;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import java.util.List;

public interface ServiceAvailableHandler {

    ServiceDto createService(ServiceDto service);

    ServiceDto findService(long id);

    List<ServiceProvided> findAll();

    ServiceDto updateService(ServiceDto serviceDto);

    OperationResponse deleteService(Long id);

    ServiceProvided getServiceById(Long id);

}
