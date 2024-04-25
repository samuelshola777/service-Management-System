package com.serviceManagementSystem.serviceManagementSystem.data.dtos.response;

import com.serviceManagementSystem.serviceManagementSystem.data.models.enums.QuoteStatus;
import com.serviceManagementSystem.serviceManagementSystem.data.models.ServiceProvided;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteResponse {

    private Long id;

    private String customerEmailAddress;

    private String staffEmailAddress;

    private ServiceProvided service;

    private QuoteStatus status;

    private Double cost;

}
