package com.serviceManagementSystem.serviceManagementSystem.services.implementations;


import com.serviceManagementSystem.serviceManagementSystem.data.dtos.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.data.models.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.AppointmentService;
import com.serviceManagementSystem.serviceManagementSystem.data.models.RevenueReport;
import com.serviceManagementSystem.serviceManagementSystem.data.models.WorkloadReport;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.ReportService;
import com.serviceManagementSystem.serviceManagementSystem.data.models.ServiceProvided;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.ServiceAvailableHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final AppointmentService appointmentService;
    private final ServiceAvailableHandler serviceHandler;


    @Override
    public List<RevenueReport> generateRevenueReport(LocalDate startDate, LocalDate endDate) {
        Map<String, Double> revenueByServiceType = new HashMap<>();
        List<Appointment> appointments = appointmentService.findAllBetweenDates(startDate, endDate);
        for (Appointment appointment : appointments) {
            ServiceProvided service = serviceHandler.getServiceById(appointment.getService().getId());
            Double revenue = revenueByServiceType.getOrDefault(service.getName(), 0.0);
            revenueByServiceType.put(service.getName(), revenue + appointment.getCost());
        }
        List<RevenueReport> revenues = new ArrayList<>();
        revenueByServiceType.forEach((key, value) ->
                revenues.add(RevenueReport.builder()
                        .serviceType(key)
                        .revenue(value)
                        .build()));
        return revenues;
    }

    @Override
    public List<WorkloadReport> generateWorkloadReport() {
        Map<String, Long> workloadDistribution = new HashMap<>();
        List<Appointment> appointments = appointmentService.findAll();
        for (Appointment appointment : appointments) {
            String staffEmail = appointment.getStaff().getEmail();
            Long workload = workloadDistribution.getOrDefault(staffEmail, 0L);
            workloadDistribution.put(staffEmail, workload + 1);
        }
        List<WorkloadReport> reports = new ArrayList<>();
        workloadDistribution.forEach((key, value) ->
                reports.add(WorkloadReport.builder()
                        .staffEmail(key)
                        .workLoad(value)
                        .build()));
        return reports;
    }

    @Override
    public List<AppointmentDto> getCustomerRequestHistory(String customerEmail) {
        return appointmentService.getAppointmentsForCustomer(customerEmail);
    }
}
