package com.serviceManagementSystem.serviceManagementSystem.data.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignQuoteToStaffRequestDto {

    private long quoteId;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String staffEmail;

}
