package com.serviceManagementSystem.serviceManagementSystem.report.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WorkloadReport {

    private String staffEmail;

    private Long workLoad;

}
