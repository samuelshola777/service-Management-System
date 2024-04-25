package com.serviceManagementSystem.serviceManagementSystem.services.interfaces;

import com.serviceManagementSystem.serviceManagementSystem.data.dtos.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.ScheduleAppointmentRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.models.Appointment;
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
