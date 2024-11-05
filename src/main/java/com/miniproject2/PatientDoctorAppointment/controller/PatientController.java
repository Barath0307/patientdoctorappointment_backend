package com.miniproject2.PatientDoctorAppointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject2.PatientDoctorAppointment.entity.Patient;
import com.miniproject2.PatientDoctorAppointment.service.PatientService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientService patientservice;
	
	@PostMapping("/patient")
	public Patient postPatient(@RequestBody Patient emp) {
		System.out.println(emp.getName());
		return patientservice.postPatient(emp);
	}
	
	@GetMapping("/patient")
	public List<Patient> getAllPatients() {
		return patientservice.getAllPatients();
	}
	
	@DeleteMapping("/patient/{id}")
	public 	ResponseEntity<?> deletePatient(@PathVariable Long id) {
		try {
			patientservice.deletePatient(id);
			return new ResponseEntity<>(" Patient with ID - " + id + " deleted successfully.", HttpStatus.OK);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<?> getPatientByID(@PathVariable Long id) {
		Patient emp = patientservice.getPatientByID(id);
		
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/patient/{id}")
	public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient emp) {
		Patient empd = patientservice.updatePatient(id, emp);
		
		if (empd == null) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
		
		return ResponseEntity.ok(empd);

	}
}
