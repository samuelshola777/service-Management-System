package com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.controller;

import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.dtos.ServiceDto;
import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service.ServiceAvailableHandler;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceAvailableHandler serviceHandler;

    @PostMapping("/add")
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceDto service) {
        return new ResponseEntity<>(serviceHandler.createService(service), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable Long id) {
        return new ResponseEntity<>(serviceHandler.findService(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        return new ResponseEntity<>(serviceHandler.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceDto> updateService(@RequestBody ServiceDto updatedService) {
        return new ResponseEntity<>(serviceHandler.updateService(updatedService), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OperationResponse> deleteService(@PathVariable Long id) {
        return new ResponseEntity<>(serviceHandler.deleteService(id), HttpStatus.OK);
    }

}
