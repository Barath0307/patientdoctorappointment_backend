package com.miniproject2.PatientDoctorAppointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject2.PatientDoctorAppointment.entity.Patient;
import com.miniproject2.PatientDoctorAppointment.repository.PatientRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

	@Autowired
	private PatientRepo patientrepo;
	
	public Patient postPatient(Patient patient) {
		return patientrepo.save(patient);
	}
	
	public List<Patient> getAllPatients() {
		return patientrepo.findAll();
	}
	
	public void deletePatient(Long id) {
		if (!patientrepo.existsById(id)) {
			throw new EntityNotFoundException("Patient ID - " + id + " not found.");
		}
		
		patientrepo.deleteById(id);
	}
	
	public Patient getPatientByID(Long id) {
		return patientrepo.findById(id).orElse(null);
	}
	
	public Patient updatePatient(Long id, Patient patient) {
		Optional<Patient> optionalPatient = patientrepo.findById(id);
		
		if (optionalPatient.isPresent()) {
			Patient existingpatient = optionalPatient.get();
			
			existingpatient.setEmail(patient.getEmail());
			existingpatient.setName(patient.getName());
			existingpatient.setDob(patient.getDob());
			existingpatient.setPassword(patient.getPassword());
			
			return patientrepo.save(existingpatient);
		}
		
		return null;
	}
}
