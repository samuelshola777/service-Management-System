package com.serviceManagementSystem.serviceManagementSystem.quote.services;

import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;

import java.util.List;

public interface QuoteService {

    QuoteResponse requestQuote(QuoteRequest quoteRequest);

    OperationResponse acceptQuote(long quoteId);

    OperationResponse rejectQuote(long quoteId);

    QuoteResponse assignQuoteToStaff(AssignQuoteToStaffRequestDto requestDto);

    Quote getQuoteById(long quoteId);

    List<QuoteResponse> getQuoteForCustomer(String customerEmail);

    List<QuoteResponse> getQuoteForStaff(String staffEmail);

}
