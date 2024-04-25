package com.serviceManagementSystem.serviceManagementSystem.quote.services;

import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.AssignQuoteToStaffRequestDto;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteRequest;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos.QuoteResponse;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuoteServiceTest {

    @Autowired
    QuoteService quoteService;

    private QuoteRequest quoteRequest;

    @BeforeEach
    void setUp() {
        quoteRequest = new QuoteRequest();
        quoteRequest.setServiceId(1);
        quoteRequest.setCustomerEmail("adeolaFool@gmail.com");
//        quoteRequest.set
    }

    @Test
    void requestQuote() {
        assertDoesNotThrow(()->{
            quoteService.requestQuote(quoteRequest);
        });
    }

    @Test
    void acceptQuote() {

        assertDoesNotThrow(()->{
            quoteService.acceptQuote(1);
        });
    }

    @Test
    void rejectQuote() {
        assertDoesNotThrow(()->{
            quoteService.rejectQuote(1);
        });
    }


    @Test
    void assignQuoteToStaff() {
        AssignQuoteToStaffRequestDto assignQuoteToStaffRequestDto = new AssignQuoteToStaffRequestDto();
        assignQuoteToStaffRequestDto.setQuoteId(1);
        assignQuoteToStaffRequestDto.setStaffEmail("uncleNewStaff@gmail.com");

        quoteService.assignQuoteToStaff(assignQuoteToStaffRequestDto);
    }

    @Test
    void getQuoteById() {
        Quote quoteRequest = quoteService.getQuoteById(1);
        assertNotNull(quoteRequest);
    }

    @Test
    void getQuoteForCustomer() {
        List<QuoteResponse> getQuoteForCustomer = quoteService.getQuoteForCustomer("adeolaFool@gmail.com");
    assertNotNull(getQuoteForCustomer);
    }

    @Test
    void getQuoteForStaff() {
        List<QuoteResponse> getQuoteForCustomer = quoteService.getQuoteForStaff("uncleNewStaff@gmail.com");
        assertNotNull(getQuoteForCustomer);
    }

    @Test
    void testRequestQuote() {

        QuoteRequest quoteRequest = new QuoteRequest();
        quoteRequest.setServiceId(1);
        quoteRequest.setCustomerEmail("adeolaFool@gmail.com");

        assertDoesNotThrow(()->{
            quoteService.requestQuote(quoteRequest);
        });
    }

    @Test
    void testAcceptQuote() {
        OperationResponse response = quoteService.acceptQuote(1);
        assertNotNull(response);
    }

    @Test
    void testRejectQuote() {
        OperationResponse response = quoteService.rejectQuote(1);
        assertNotNull(response);
    }

    @Test
    void testAssignQuoteToStaff() {
        AssignQuoteToStaffRequestDto toStaffRequestDto = new AssignQuoteToStaffRequestDto();
        toStaffRequestDto.setStaffEmail("uncleNewStaff@gmail.com");
        toStaffRequestDto.setQuoteId(1);
        QuoteResponse response = quoteService.assignQuoteToStaff(toStaffRequestDto);
        assertNotNull(response);
    }

    @Test
    void testGetQuoteById() {
        Quote foundQuote = quoteService.getQuoteById(1);
        assertNotNull(foundQuote);
    }

    @Test
    void testGetQuoteForCustomer() {
        List<QuoteResponse> responses = quoteService.getQuoteForCustomer("adeolaFool@gmail.com");
        assertNotNull(responses);
    }

    @Test
    void testGetQuoteForStaff() {
        List<QuoteResponse> getQuoteForStaff = quoteService.getQuoteForStaff("uncleNewStaff@gmail.com");
        assertNotNull(getQuoteForStaff);
    }
}