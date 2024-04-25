package com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto;

import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.models.ServiceProvided;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDto {

    private Long id;

    private String customerEmail;

    private String staffEmail;

    private ServiceProvided service;

    private LocalDate date;

    private String time;

    private Double cost;

}
