package com.serviceManagementSystem.serviceManagementSystem.appointment.data.repositories;

import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByCustomer(BaseUser customer);

}
