package com.miniproject2.PatientDoctorAppointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject2.PatientDoctorAppointment.entity.Doctor;
import com.miniproject2.PatientDoctorAppointment.repository.DoctorRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {

	@Autowired
	private DoctorRepo doctorrepo;
	
	public Doctor postDoctor(Doctor doctor) {
		return doctorrepo.save(doctor);
	}
	
	public List<Doctor> getAllDoctors() {
		return doctorrepo.findAll();
	}
	
	public void deleteDoctor(Long id) {
		if (!doctorrepo.existsById(id)) {
			throw new EntityNotFoundException("Doctor ID - " + id + " not found.");
		}
		
		doctorrepo.deleteById(id);
	}
	
	public Doctor getDoctorByID(Long id) {
		return doctorrepo.findById(id).orElse(null);
	}
	
	public Doctor updateDoctor(Long id, Doctor doctor) {
		Optional<Doctor> optionalDoctor = doctorrepo.findById(id);
		
		if (optionalDoctor.isPresent()) {
			Doctor existingdoctor = optionalDoctor.get();
			
			existingdoctor.setName(doctor.getName());
			existingdoctor.setSpecialization(doctor.getSpecialization());
			existingdoctor.setPassword(doctor.getPassword());
			existingdoctor.setState(doctor.getState());
			existingdoctor.setCity(doctor.getCity());
			existingdoctor.setDegree(doctor.getDegree());
			
			return doctorrepo.save(existingdoctor);
		}
		
		return null;
	}
}
