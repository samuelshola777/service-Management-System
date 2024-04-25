package com.serviceManagementSystem.serviceManagementSystem.appointment.data.repositories;

import com.serviceManagementSystem.serviceManagementSystem.appointment.data.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
