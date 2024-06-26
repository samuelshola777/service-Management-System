package com.serviceManagementSystem.serviceManagementSystem.services.implementations;


import com.serviceManagementSystem.serviceManagementSystem.exceptions.ServiceNotFoundException;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.ServiceAvailableHandler;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.ServiceDto;
import com.serviceManagementSystem.serviceManagementSystem.data.models.ServiceProvided;
import com.serviceManagementSystem.serviceManagementSystem.data.repositories.ServiceRepository;
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
        ServiceProvided serviceProvided = ServiceProvided.builder()
                .name(service.getName())
                .cost(service.getCost())
                .description(service.getDescription())
                .estimatedDurationInDays(service.getEstimatedDurationInDays())
                .build();
        ServiceProvided savedServiceProvided = serviceRepository.save(serviceProvided);
        return ServiceDto.builder()
                .id(savedServiceProvided.getId())
                .name(savedServiceProvided.getName())
                .cost(savedServiceProvided.getCost())
                .description(savedServiceProvided.getDescription())
                .estimatedDurationInDays(savedServiceProvided.getEstimatedDurationInDays())
                .build();
    }

    @Override
    public ServiceDto findService(long id) {
        ServiceProvided serviceProvided = getServiceById(id);
        return ServiceDto.builder()
                .id(serviceProvided.getId())
                .name(serviceProvided.getName())
                .cost(serviceProvided.getCost())
                .description(serviceProvided.getDescription())
                .estimatedDurationInDays(serviceProvided.getEstimatedDurationInDays())
                .build();
    }

    @Override
    public List<ServiceProvided> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceDto updateService(ServiceDto serviceDto) {
        ServiceProvided serviceProvided = serviceRepository.findById(serviceDto.getId()).orElseThrow(ServiceNotFoundException::new);
        serviceProvided.setName(serviceDto.getName());
        serviceProvided.setDescription(serviceDto.getDescription());
        serviceProvided.setCost(serviceDto.getCost());
        serviceProvided.setEstimatedDurationInDays(serviceDto.getEstimatedDurationInDays());
        ServiceProvided savedServiceProvided = serviceRepository.save(serviceProvided);
        return ServiceDto.builder()
                .id(savedServiceProvided.getId())
                .name(savedServiceProvided.getName())
                .cost(savedServiceProvided.getCost())
                .description(savedServiceProvided.getDescription())
                .estimatedDurationInDays(savedServiceProvided.getEstimatedDurationInDays())
                .build();
    }

    @Override
    public OperationResponse deleteService(Long id) {
        ServiceProvided serviceProvided = serviceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);
        serviceRepository.delete(serviceProvided);
        return OperationResponse.builder()
                .status("SUCCESSFUL")
                .build();
    }

    @Override
    public ServiceProvided getServiceById(Long id) {
        return serviceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);
    }
}
