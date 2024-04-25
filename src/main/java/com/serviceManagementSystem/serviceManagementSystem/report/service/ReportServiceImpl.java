package com.serviceManagementSystem.serviceManagementSystem.report.service;


import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.appointment.services.AppointmentService;
import com.serviceManagementSystem.serviceManagementSystem.report.model.RevenueReport;
import com.serviceManagementSystem.serviceManagementSystem.report.model.WorkloadReport;
import com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.service.ServiceAvailableHandler;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.service.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final AppointmentService appointmentService;
    private final ServiceAvailableHandler serviceHandler;
    private final BaseUserService userService;


    @Override
    public List<RevenueReport> generateRevenueReport(String startDate, String endDate) {
        return List.of();
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
        return List.of();
    }

    @Override
    public List<AppointmentDto> getCustomerRequestHistory(Long customerId) {
        return List.of();
    }
}
