package com.serviceManagementSystem.serviceManagementSystem.services.implementations;


import com.serviceManagementSystem.serviceManagementSystem.exceptions.QuoteNotFoundException;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.response.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.data.models.enums.QuoteStatus;
import com.serviceManagementSystem.serviceManagementSystem.data.repositories.QuoteRepository;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.QuoteService;
import com.serviceManagementSystem.serviceManagementSystem.data.models.ServiceProvided;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.ServiceAvailableHandler;
import com.serviceManagementSystem.serviceManagementSystem.data.models.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.BaseUserService;
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
    public OperationResponse acceptQuote(long quoteId) {
        Quote aQuote = getQuoteById(quoteId);
        aQuote.setStatus(QuoteStatus.ACCEPTED);
        quoteRepository.save(aQuote);
        return OperationResponse.builder()
                .status("SUCCESSFUL")
                .build();
    }

    @Override
    public OperationResponse rejectQuote(long quoteId) {
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
    public Quote getQuoteById(long quoteId) {
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

    @Override
    public List<QuoteResponse> getQuoteForStaff(String staffEmail) {
        List<Quote> allQuotes = quoteRepository.findAllByStaffAssignedTo(userService.getStaffUserByEmail(staffEmail));
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
