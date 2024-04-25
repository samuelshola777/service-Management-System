package com.serviceManagementSystem.serviceManagementSystem.services.interfaces;

import com.serviceManagementSystem.serviceManagementSystem.data.dtos.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.data.models.RevenueReport;
import com.serviceManagementSystem.serviceManagementSystem.data.models.WorkloadReport;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    List<RevenueReport> generateRevenueReport(LocalDate startDate, LocalDate endDate);

    List<WorkloadReport> generateWorkloadReport();

    List<AppointmentDto> getCustomerRequestHistory(String customerEmail);

}
