package com.serviceManagementSystem.serviceManagementSystem.customer.data.model;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.AppUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private AppUser appUser;
}
