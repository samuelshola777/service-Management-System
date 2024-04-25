package com.serviceManagementSystem.serviceManagementSystem.quote.controller;


import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.quote.services.QuoteService;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quote")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @PostMapping("/requestQuote")
    public ResponseEntity<QuoteResponse> requestQuote(@RequestBody QuoteRequest quoteRequest) {
        return new ResponseEntity<>(quoteService.requestQuote(quoteRequest), HttpStatus.OK);
    }

    @PostMapping("/acceptQuote/{quoteId}")
    public ResponseEntity<OperationResponse> acceptQuote(@PathVariable Long quoteId) {
        return new ResponseEntity<>(quoteService.acceptQuote(quoteId), HttpStatus.OK);
    }

    @PostMapping("/rejectQuote/{quoteId}")
    public ResponseEntity<OperationResponse> rejectQuote(@PathVariable Long quoteId) {
        return new ResponseEntity<>(quoteService.rejectQuote(quoteId), HttpStatus.OK);
    }

    @PostMapping("/assign")
    public ResponseEntity<QuoteResponse> assignQuoteToStaff(@RequestBody AssignQuoteToStaffRequestDto requestDto) {
        return new ResponseEntity<>(quoteService.assignQuoteToStaff(requestDto), HttpStatus.OK);
    }


}
