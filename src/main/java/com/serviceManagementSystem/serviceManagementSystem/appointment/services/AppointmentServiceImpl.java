package com.serviceManagementSystem.serviceManagementSystem.appointment.services;


import com.serviceManagementSystem.serviceManagementSystem.appointment.data.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

}
