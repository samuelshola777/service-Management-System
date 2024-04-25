package com.serviceManagementSystem.serviceManagementSystem.quote.data.repository;

import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {


}
