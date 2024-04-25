package com.serviceManagementSystem.serviceManagementSystem.report.controller;


import com.serviceManagementSystem.serviceManagementSystem.appointment.data.dto.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.report.model.RevenueReport;
import com.serviceManagementSystem.serviceManagementSystem.report.model.WorkloadReport;
import com.serviceManagementSystem.serviceManagementSystem.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/revenue")
    public ResponseEntity<List<RevenueReport>> generateRevenueReport(@RequestParam String startDate, @RequestParam String endDate) {
        return new ResponseEntity<>(reportService.generateRevenueReport(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/workload")
    public ResponseEntity<List<WorkloadReport>> generateWorkloadReport() {
        return new ResponseEntity<>(reportService.generateWorkloadReport(), HttpStatus.OK);
    }

    @GetMapping("/customer/history/")
    public ResponseEntity<List<AppointmentDto>> getCustomerRequestHistory(@RequestParam String customerEmail) {
        return new ResponseEntity<>(reportService.getCustomerRequestHistory(customerEmail), HttpStatus.OK);
    }

}
