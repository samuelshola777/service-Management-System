package com.serviceManagementSystem.serviceManagementSystem.quote.services;


import com.serviceManagementSystem.serviceManagementSystem.exceptions.QuoteNotFoundException;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.enums.QuoteStatus;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.repository.QuoteRepository;
import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service.ServiceAvailableHandler;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.service.BaseUserService;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final ServiceAvailableHandler servicesHandler;
    private final BaseUserService userService;

    @Override
    public QuoteResponse requestQuote(QuoteRequest quoteRequest) {
        Quote aQuote = Quote.builder()
                .customer(userService.getCustomerUserByEmail(quoteRequest.getCustomerEmail()))
                .staffAssignedTo(null)
                .status(QuoteStatus.PENDING)
                .service(servicesHandler.getServiceById(quoteRequest.getServiceId()))
                .build();
        Quote savedQuote = quoteRepository.save(aQuote);
        return QuoteResponse.builder()
                .id(savedQuote.getId())
                .service(savedQuote.getService())
                .customerEmailAddress(savedQuote.getCustomer().getEmail())
                .staffEmailAddress("")
                .status(savedQuote.getStatus())
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
                .build();
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        return quoteRepository.findById(quoteId).orElseThrow(QuoteNotFoundException::new);
    }
}
