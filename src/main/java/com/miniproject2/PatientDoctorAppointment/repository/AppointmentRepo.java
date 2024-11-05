package com.miniproject2.PatientDoctorAppointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject2.PatientDoctorAppointment.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
	
	List<Appointment> findAppointmentsBydocid(Long doctorId);

}
