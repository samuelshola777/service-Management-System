package com.serviceManagementSystem.serviceManagementSystem.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private BaseUser customer;

    @ManyToOne(fetch = FetchType.EAGER)
    private BaseUser staff;

    @ManyToOne(fetch = FetchType.EAGER)
    private ServiceProvided service;

    private Double cost;

    private LocalDate date;

    private String time;

    private long rescheduleCount;

}
