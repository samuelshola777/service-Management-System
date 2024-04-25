package com.serviceManagementSystem.serviceManagementSystem.quote.data.repository;

import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.QuoteRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<QuoteRequest, Long> {


}
