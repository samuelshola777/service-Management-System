package com.serviceManagementSystem.serviceManagementSystem.appUser.data.repository;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    boolean existsEmail(String email);

    AppUser findByEmail(String email);
}
