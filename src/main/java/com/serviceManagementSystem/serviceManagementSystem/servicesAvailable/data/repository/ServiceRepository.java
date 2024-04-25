package com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.repository;

import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.models.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceProvided, Long> {

}
