package com.serviceManagementSystem.serviceManagementSystem.quote.data.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuoteRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String customerEmail;

    private Long serviceId;

}
