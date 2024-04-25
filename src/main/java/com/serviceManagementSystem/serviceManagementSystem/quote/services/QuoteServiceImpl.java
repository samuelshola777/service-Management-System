package com.serviceManagementSystem.serviceManagementSystem.quote.services;


import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.repository.QuoteRepository;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    @Override
    public QuoteResponse requestQuote(QuoteRequest quoteRequest) {
        return null;
    }

    @Override
    public OperationResponse acceptQuote(Long quoteId) {
        return null;
    }

    @Override
    public OperationResponse rejectQuote(Long quoteId) {
        return null;
    }

    @Override
    public QuoteResponse assignQuoteToStaff(AssignQuoteToStaffRequestDto requestDto) {
        return null;
    }
}
