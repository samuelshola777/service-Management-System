package com.serviceManagementSystem.serviceManagementSystem.quote.data.repository;

import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findAllByCustomer(BaseUser customer);

}
