package com.serviceManagementSystem.serviceManagementSystem.appointment.services;


import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

}
