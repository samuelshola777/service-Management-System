package com.serviceManagementSystem.serviceManagementSystem.data.repositories;

import com.serviceManagementSystem.serviceManagementSystem.data.models.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.data.models.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByCustomer(BaseUser customer);

}
