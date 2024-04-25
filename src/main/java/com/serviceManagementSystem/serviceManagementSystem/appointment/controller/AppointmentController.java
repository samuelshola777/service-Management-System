package com.serviceManagementSystem.serviceManagementSystem.appointment.controller;

import com.serviceManagementSystem.serviceManagementSystem.appointment.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

}
