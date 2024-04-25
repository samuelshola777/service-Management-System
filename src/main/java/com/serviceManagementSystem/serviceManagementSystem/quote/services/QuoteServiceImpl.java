package com.serviceManagementSystem.serviceManagementSystem.quote.services;


import com.serviceManagementSystem.serviceManagementSystem.quote.data.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

}
