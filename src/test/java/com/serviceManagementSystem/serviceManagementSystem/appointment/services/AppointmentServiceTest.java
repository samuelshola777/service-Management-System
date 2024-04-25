package com.serviceManagementSystem.serviceManagementSystem.appointment.services;

import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.ScheduleAppointmentRequest;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentServiceTest {
    @Autowired
    AppointmentService appointmentService;

  private   ScheduleAppointmentRequest scheduleAppointmentRequest;


    @BeforeEach
    void setUp() {
        scheduleAppointmentRequest = new ScheduleAppointmentRequest();
        scheduleAppointmentRequest.setTime("537");
        scheduleAppointmentRequest.setQuoteId( 1);
        scheduleAppointmentRequest.setDate(LocalDate.now().plusDays(3));
    }

    @Test
    void scheduleAppointment() {
        assertDoesNotThrow(()->{
            appointmentService.scheduleAppointment(scheduleAppointmentRequest);
        });


    }

    @Test
    void findAll() {
        List<Appointment> listOfAppointment = appointmentService.findAll();
        assertNotNull(listOfAppointment);

    }

    @Test
    void getAppointmentsForCustomer() {
        List<AppointmentDto> listOfAppointment = appointmentService.getAppointmentsForCustomer("adeolaFool@gmail.com");
        assertNotNull(listOfAppointment);
    }

    @Test
    void findAllBetweenDates() {
        List<Appointment> findAllBetweenDates = appointmentService.findAllBetweenDates(LocalDate.now(), LocalDate.now().plusDays(2));
    }

    @Test
    void getCustomerUpcomingAppointments() {

        List<AppointmentDto> getCustomerUpcomingAppointments = appointmentService.getCustomerUpcomingAppointments("adeolaFool@gmail.com");
    assertNotNull(getCustomerUpcomingAppointments);
    }

    @Test
    void rescheduleAppointment() {
        AppointmentDto updatedAppointment = new AppointmentDto();
        updatedAppointment.setDate(LocalDate.now());
        updatedAppointment.setTime("7");
        OperationResponse rescheduleAppointment = appointmentService.rescheduleAppointment(1,updatedAppointment);
  assertNotNull(rescheduleAppointment);
    }

    @Test
    void getAppointmentById() {
        Appointment getAppointmentById = appointmentService.getAppointmentById(1);
        assertNotNull(getAppointmentById);
    }
}