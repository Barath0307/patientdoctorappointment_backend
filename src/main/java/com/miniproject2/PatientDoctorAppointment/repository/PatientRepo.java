package com.miniproject2.PatientDoctorAppointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject2.PatientDoctorAppointment.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

}
