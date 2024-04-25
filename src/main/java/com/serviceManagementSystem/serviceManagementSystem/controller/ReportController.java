package com.serviceManagementSystem.serviceManagementSystem.controller;


import com.serviceManagementSystem.serviceManagementSystem.data.dtos.AppointmentDto;
import com.serviceManagementSystem.serviceManagementSystem.data.models.RevenueReport;
import com.serviceManagementSystem.serviceManagementSystem.data.models.WorkloadReport;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/revenue")
    public ResponseEntity<List<RevenueReport>> generateRevenueReport(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
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
