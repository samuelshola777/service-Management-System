package com.serviceManagementSystem.serviceManagementSystem.servicesAvailable.data.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDto {

    private Long id;

    private String name;

    private String description;

    private Integer estimatedDurationInDays;

    private Double cost;

}
