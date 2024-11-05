package com.miniproject2.PatientDoctorAppointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<com.miniproject2.PatientDoctorAppointment.entity.User, Long> {
    Optional<com.miniproject2.PatientDoctorAppointment.entity.User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
