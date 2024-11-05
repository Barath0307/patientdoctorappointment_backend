package com.miniproject2.PatientDoctorAppointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject2.PatientDoctorAppointment.entity.Appointment;
import com.miniproject2.PatientDoctorAppointment.repository.AppointmentRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	@Autowired
	private AppointmentRepo apprepo;
	
	public Appointment postAppointment(Appointment app) {
		return apprepo.save(app);
	}
	
	public List<Appointment> getAllAppointments() {
		return apprepo.findAll();
	}
	
	public List<Appointment> getAppointmentByDoctorID(long doctorid) {
		
		return apprepo.findAppointmentsBydocid(doctorid);
	}
	
	public void deleteAppointment(Long id) {
		if (!apprepo.existsById(id)) {
			throw new EntityNotFoundException("Appointment ID - " + id + " not found.");
		}
		
		apprepo.deleteById(id);
	}
	
	public Appointment getAppointmentByID(Long id) {
		return apprepo.findById(id).orElse(null);
	}
	
	public Appointment updateAppointment(Long id, Appointment Appointment) {
		Optional<Appointment> optionalAppointment = apprepo.findById(id);
		
		if (optionalAppointment.isPresent()) {
			Appointment existingAppointment = optionalAppointment.get();
			
			existingAppointment.setDate(Appointment.getDate());
			existingAppointment.setDocspecialization(Appointment.getDocspecialization());
			existingAppointment.setDocid(Appointment.getDocid());
			existingAppointment.setDocname(Appointment.getDocname());
			existingAppointment.setEmail(Appointment.getEmail());
			existingAppointment.setSlot(Appointment.getSlot());
			existingAppointment.setStatus(Appointment.getStatus());
			
			return apprepo.save(existingAppointment);
		}
		
		return null;
	}
}
