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

import com.miniproject2.PatientDoctorAppointment.entity.Doctor;
import com.miniproject2.PatientDoctorAppointment.service.DoctorService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorservice;
	
	@PostMapping("/doctor")
	public Doctor postDoctor(@RequestBody Doctor doc) {
		System.out.println(doc.getName());
		return doctorservice.postDoctor(doc);
	}
	
	@GetMapping("/doctor")
	public List<Doctor> getAllDoctors() {
		return doctorservice.getAllDoctors();
	}
	
	@DeleteMapping("/doctor/{id}")
	public 	ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
		try {
			doctorservice.deleteDoctor(id);
			return new ResponseEntity<>(" Doctor with ID - " + id + " deleted successfully.", HttpStatus.OK);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<?> getDoctorByID(@PathVariable Long id) {
		Doctor doc = doctorservice.getDoctorByID(id);
		
		if (doc == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(doc);
	}
	
	@PutMapping("/doctor/{id}")
	public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody Doctor doc) {
		Doctor docd = doctorservice.updateDoctor(id, doc);
		
		if (docd == null) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
		
		return ResponseEntity.ok(docd);

	}
}
