package com.serviceManagementSystem.serviceManagementSystem.customer.data.repository;

import com.serviceManagementSystem.serviceManagementSystem.customer.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
