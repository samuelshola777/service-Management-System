package com.serviceManagementSystem.serviceManagementSystem.quote.services;


import com.serviceManagementSystem.serviceManagementSystem.exceptions.QuoteNotFoundException;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.enums.QuoteStatus;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.repository.QuoteRepository;
import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.models.ServiceProvided;
import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service.ServiceAvailableHandler;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.service.BaseUserService;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final ServiceAvailableHandler servicesHandler;
    private final BaseUserService userService;

    @Override
    public QuoteResponse requestQuote(QuoteRequest quoteRequest) {
        ServiceProvided service = servicesHandler.getServiceById(quoteRequest.getServiceId());
        Quote aQuote = Quote.builder()
                .customer(userService.getCustomerUserByEmail(quoteRequest.getCustomerEmail()))
                .staffAssignedTo(null)
                .status(QuoteStatus.PENDING)
                .service(service)
                .cost(service.getCost())
                .build();
        Quote savedQuote = quoteRepository.save(aQuote);
        return QuoteResponse.builder()
                .id(savedQuote.getId())
                .service(savedQuote.getService())
                .customerEmailAddress(savedQuote.getCustomer().getEmail())
                .staffEmailAddress("")
                .status(savedQuote.getStatus())
                .cost(savedQuote.getCost())
                .build();
    }

    @Override
    public OperationResponse acceptQuote(Long quoteId) {
        Quote aQuote = getQuoteById(quoteId);
        aQuote.setStatus(QuoteStatus.ACCEPTED);
        quoteRepository.save(aQuote);
        return OperationResponse.builder()
                .status("SUCCESSFUL")
                .build();
    }

    @Override
    public OperationResponse rejectQuote(Long quoteId) {
        Quote aQuote = getQuoteById(quoteId);
        aQuote.setStatus(QuoteStatus.REJECTED);
        quoteRepository.save(aQuote);
        return OperationResponse.builder()
                .status("SUCCESSFUL")
                .build();
    }

    @Override
    public QuoteResponse assignQuoteToStaff(AssignQuoteToStaffRequestDto requestDto) {
        Quote aQuote = getQuoteById(requestDto.getQuoteId());
        BaseUser staff = userService.getStaffUserByEmail(requestDto.getStaffEmail());
        aQuote.setStaffAssignedTo(staff);
        aQuote.setStatus(QuoteStatus.ACCEPTED);
        Quote savedQuote = quoteRepository.save(aQuote);
        return QuoteResponse.builder()
                .id(savedQuote.getId())
                .service(savedQuote.getService())
                .customerEmailAddress(savedQuote.getCustomer().getEmail())
                .staffEmailAddress(savedQuote.getStaffAssignedTo().getEmail())
                .status(savedQuote.getStatus())
                .cost(savedQuote.getCost())
                .build();
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        return quoteRepository.findById(quoteId).orElseThrow(QuoteNotFoundException::new);
    }

    @Override
    public List<QuoteResponse> getQuoteForCustomer(String customerEmail) {
        List<Quote> allQuotes = quoteRepository.findAllByCustomer(userService.getCustomerUserByEmail(customerEmail));
        return allQuotes.stream().map(savedQuote -> QuoteResponse.builder()
                .id(savedQuote.getId())
                .service(savedQuote.getService())
                .customerEmailAddress(savedQuote.getCustomer().getEmail())
                .staffEmailAddress(
                        savedQuote.getStaffAssignedTo() == null ? "" : savedQuote.getStaffAssignedTo().getEmail()
                )
                .status(savedQuote.getStatus())
                .cost(savedQuote.getCost())
                .build()).toList();
    }
}
