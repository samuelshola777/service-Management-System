package com.serviceManagementSystem.serviceManagementSystem.appointment.services;

import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    List<Appointment> findAll();

    List<AppointmentDto> getQuoteForCustomer(String customerEmail);

    List<Appointment> findAllBetweenDates(LocalDate startDate, LocalDate endDate);

}
