package com.serviceManagementSystem.serviceManagementSystem.appointment.services;

import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.ScheduleAppointmentRequest;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    OperationResponse scheduleAppointment(ScheduleAppointmentRequest newAppointment);

    List<Appointment> findAll();

    List<AppointmentDto> getAppointmentsForCustomer(String customerEmail);

    List<Appointment> findAllBetweenDates(LocalDate startDate, LocalDate endDate);

    List<AppointmentDto> getCustomerUpcomingAppointments(String customerEmail);

    OperationResponse rescheduleAppointment(long appointmentId, AppointmentDto updatedAppointment);

    Appointment getAppointmentById(long appointmentId);

}
