package com.serviceManagementSystem.serviceManagementSystem.appointment.services;


import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.ScheduleAppointmentRequest;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.repositories.AppointmentRepository;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.AppointmentNotFoundException;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.UnableToRescheduleException;
import com.serviceManagementSystem.serviceManagementSystem.quote.data.models.Quote;
import com.serviceManagementSystem.serviceManagementSystem.quote.services.QuoteService;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.service.BaseUserService;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final BaseUserService userService;
    private final QuoteService quoteService;

    @Override
    public OperationResponse scheduleAppointment(ScheduleAppointmentRequest newAppointment) {
        Quote foundQuote = quoteService.getQuoteById(newAppointment.getQuoteId());
        Appointment appointment = Appointment.builder()
                .customer(foundQuote.getCustomer())
                .staff(foundQuote.getStaffAssignedTo())
                .service(foundQuote.getService())
                .cost(foundQuote.getCost())
                .date(newAppointment.getDate())
                .time(newAppointment.getTime())
                .rescheduleCount(0L)
                .build();
        appointmentRepository.save(appointment);
        return OperationResponse.builder()
                .status("SUCCESSFUL")
                .build();
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<AppointmentDto> getAppointmentsForCustomer(String customerEmail) {
        List<Appointment> allAppointments = getAllCustomerAppointments(customerEmail);
        return allAppointments
                .stream()
                .map(appointment -> AppointmentDto.builder()
                        .id(appointment.getId())
                        .customerEmail(appointment.getCustomer().getEmail())
                        .staffEmail(appointment.getStaff().getEmail())
                        .service(appointment.getService())
                        .date(appointment.getDate())
                        .time(appointment.getTime())
                        .cost(appointment.getCost())
                        .build()
                )
                .toList();
    }

    private List<Appointment> getAllCustomerAppointments(String customerEmail) {
        return appointmentRepository
                .findAllByCustomer(
                        userService.getCustomerUserByEmail(customerEmail)
                );
    }

    @Override
    public List<Appointment> findAllBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<Appointment> allAppointments = appointmentRepository.findAll();
        return allAppointments
                .stream()
                .filter(
                        appointment ->
                                appointment.getDate().isAfter(startDate) &&
                                        appointment.getDate().isBefore(endDate)
                )
                .toList();
    }

    @Override
    public List<AppointmentDto> getCustomerUpcomingAppointments(String customerEmail) {
        List<Appointment> customerAppointments = getAllCustomerAppointments(customerEmail);
        return customerAppointments
                .stream()
                .filter(appointment -> appointment.getDate().isAfter(LocalDate.now()))
                .map(appointment -> AppointmentDto.builder()
                        .id(appointment.getId())
                        .customerEmail(appointment.getCustomer().getEmail())
                        .staffEmail(appointment.getStaff().getEmail())
                        .service(appointment.getService())
                        .date(appointment.getDate())
                        .time(appointment.getTime())
                        .cost(appointment.getCost())
                        .build()
                )
                .toList();
    }

    @Override
    public OperationResponse rescheduleAppointment(long appointmentId, AppointmentDto updatedAppointment) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment.getRescheduleCount() > 3) {
            throw new UnableToRescheduleException();
        }
        appointment.setDate(updatedAppointment.getDate());
        appointment.setTime(updatedAppointment.getTime());
        appointment.setRescheduleCount(appointment.getRescheduleCount() + 1);
        appointmentRepository.save(appointment);
        return OperationResponse.builder()
                .status("SUCCESSFUL")
                .build();
    }

    @Override
    public Appointment getAppointmentById(long appointmentId) {
        return appointmentRepository
                .findById(appointmentId)
                .orElseThrow(AppointmentNotFoundException::new);
    }

}
