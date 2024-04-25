package com.serviceManagementSystem.serviceManagementSystem.report.service;

import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.report.model.RevenueReport;
import com.serviceManagementSystem.serviceManagementSystem.report.model.WorkloadReport;
import java.util.List;

public interface ReportService {

    List<RevenueReport> generateRevenueReport(String startDate, String endDate);

    List<WorkloadReport> generateWorkloadReport();

    List<AppointmentDto> getCustomerRequestHistory(String customerEmail);

}
