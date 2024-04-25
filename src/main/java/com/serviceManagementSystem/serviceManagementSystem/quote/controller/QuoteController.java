package com.serviceManagementSystem.serviceManagementSystem.quote.controller;


import com.serviceManagementSystem.serviceManagementSystem.quote.services.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quote")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

}
