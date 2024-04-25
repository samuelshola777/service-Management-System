package com.serviceManagementSystem.serviceManagementSystem.data.models;

import com.serviceManagementSystem.serviceManagementSystem.data.models.enums.QuoteStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BaseUser customer;

    @ManyToOne
    private BaseUser staffAssignedTo;

    @ManyToOne
    private ServiceProvided service;

    private QuoteStatus status;

    private Double cost;

}
