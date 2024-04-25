package com.serviceManagementSystem.serviceManagementSystem.quote.services;

import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;

public interface QuoteService {

    QuoteResponse requestQuote(QuoteRequest quoteRequest);

    OperationResponse acceptQuote(Long quoteId);

    OperationResponse rejectQuote(Long quoteId);

    QuoteResponse assignQuoteToStaff(AssignQuoteToStaffRequestDto requestDto);

    Quote getQuoteById(Long quoteId);
}
