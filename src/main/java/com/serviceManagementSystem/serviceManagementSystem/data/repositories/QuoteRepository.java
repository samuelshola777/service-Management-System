package com.serviceManagementSystem.serviceManagementSystem.data.repositories;

import com.serviceManagementSystem.serviceManagementSystem.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.data.models.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findAllByCustomer(BaseUser customer);

    List<Quote> findAllByStaffAssignedTo(BaseUser staff);

}
