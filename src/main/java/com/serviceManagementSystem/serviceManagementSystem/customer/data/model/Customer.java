package com.serviceManagementSystem.serviceManagementSystem.customer.data.model;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private AppUser appUser;
    private LocalDateTime registrationDate;
}
