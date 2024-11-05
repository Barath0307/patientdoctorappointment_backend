package com.miniproject2.PatientDoctorAppointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject2.PatientDoctorAppointment.entity.Appointment;
import com.miniproject2.PatientDoctorAppointment.service.AppointmentService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentservice;
	
	@PostMapping("/appointment")
	public Appointment postAppointment(@RequestBody Appointment app) {
		System.out.println(app.getDocname());
		return appointmentservice.postAppointment(app);
	}
	
	@GetMapping("/appointment")
	public List<Appointment> getAllAppointments() {
		return appointmentservice.getAllAppointments();
	}
	
	@DeleteMapping("/appointment/{id}")
	public 	ResponseEntity<?> deleteAppointment(@PathVariable Long id) {
		try {
			appointmentservice.deleteAppointment(id);
			return new ResponseEntity<>(" Doctor with ID - " + id + " deleted successfully.", HttpStatus.OK);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/appointment/{id}")
	public ResponseEntity<?> getAppointmentByID(@PathVariable Long id) {
		Appointment doc = appointmentservice.getAppointmentByID(id);
		
		if (doc == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(doc);
	}
	
	@GetMapping("/appointment/doctor/{id}")
	public List<Appointment> getAppointmentByDoctorID(@PathVariable Long id) {
		return appointmentservice.getAppointmentByDoctorID(id);
	}
	
	@PutMapping("/appointment/{id}")
	public ResponseEntity<?> updateAppointment(@PathVariable Long id, @RequestBody Appointment doc) {
		Appointment docd = appointmentservice.updateAppointment(id, doc);
		
		if (docd == null) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
		
		return ResponseEntity.ok(docd);

	}
}
