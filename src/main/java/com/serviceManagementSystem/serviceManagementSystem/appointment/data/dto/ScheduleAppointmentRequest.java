package com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ScheduleAppointmentRequest {

    private Long quoteId;

    private LocalDate date;

    private String time;

}
