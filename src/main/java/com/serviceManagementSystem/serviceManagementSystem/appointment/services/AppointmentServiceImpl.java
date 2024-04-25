package com.serviceManagementSystem.serviceManagementSystem.appointment.services;


import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.repositories.AppointmentRepository;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.service.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final BaseUserService userService;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<AppointmentDto> getQuoteForCustomer(String customerEmail) {
        List<Appointment> allAppointments = appointmentRepository.findAllByCustomer(userService.getCustomerUserByEmail(customerEmail));
        return allAppointments.stream().map(appointment -> AppointmentDto.builder()
                .id(appointment.getId())
                .service(appointment.getService())
                .customerEmail(appointment.getCustomer().getEmail())
                .staffEmail(appointment.getStaff().getEmail())
                .date(appointment.getDate())
                .time(appointment.getTime())
                .build()).toList();
    }

    @Override
    public List<Appointment> findAllBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<Appointment> allAppointments = appointmentRepository.findAll();
        return allAppointments.stream().filter(
                appointment ->
                        appointment.getDate().isAfter(startDate)
                        &&
                        appointment.getDate().isBefore(endDate)).toList();
    }

}
