package com.serviceManagementSystem.serviceManagementSystem.userManagement.data.repository;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    boolean existsByEmailAndRole(String email, SystemRole systemRole);

    Optional<BaseUser> findByEmailAndRole(String email, SystemRole systemRole);

    Optional<BaseUser> findByEmail(String email);

    boolean existsByEmail(String email);

}
