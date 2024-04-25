package com.serviceManagementSystem.serviceManagementSystem.admin.data.model;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.AppUser;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StaffAdmin {
    private AppUser appUser;
}
