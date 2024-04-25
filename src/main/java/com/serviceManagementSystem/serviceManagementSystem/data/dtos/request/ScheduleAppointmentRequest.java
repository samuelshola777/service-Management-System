package com.serviceManagementSystem.serviceManagementSystem.data.dtos.request;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ScheduleAppointmentRequest {

    private long quoteId;

    private LocalDate date;

    private String time;

}
