package com.serviceManagementSystem.serviceManagementSystem.controller;

import com.serviceManagementSystem.serviceManagementSystem.data.dtos.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.ScheduleAppointmentRequest;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.AppointmentService;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/schedule")
    public ResponseEntity<OperationResponse> scheduleAppointment(@RequestBody ScheduleAppointmentRequest newAppointment) {
        return new ResponseEntity<>(appointmentService.scheduleAppointment(newAppointment), HttpStatus.OK);
    }

    @GetMapping("/customer/upcoming")
    public ResponseEntity<List<AppointmentDto>> getCustomerUpcomingAppointments(@RequestParam String customerEmail) {
        return new ResponseEntity<>(appointmentService.getCustomerUpcomingAppointments(customerEmail), HttpStatus.OK);
    }

    @PostMapping("/customer/reschedule/{appointmentId}")
    public ResponseEntity<OperationResponse> rescheduleAppointment(@PathVariable Long appointmentId, @RequestBody AppointmentDto updatedAppointment) {
        return new ResponseEntity<>(appointmentService.rescheduleAppointment(appointmentId, updatedAppointment), HttpStatus.OK);
    }

}
