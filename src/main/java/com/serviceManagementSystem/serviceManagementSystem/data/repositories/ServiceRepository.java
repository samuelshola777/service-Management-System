package com.serviceManagementSystem.serviceManagementSystem.data.repositories;

import com.serviceManagementSystem.serviceManagementSystem.data.models.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceProvided, Long> {

}
