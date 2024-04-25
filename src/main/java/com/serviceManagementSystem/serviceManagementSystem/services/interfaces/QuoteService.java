package com.serviceManagementSystem.serviceManagementSystem.services.interfaces;

import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.response.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.data.models.Quote;
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
