package com.miniproject2.PatientDoctorAppointment.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	
	private long docid;
	
	private String docname;
	
	private String docspecialization;
	
	private String status;
	
	private Date date;
	
	private String slot;

	public Appointment(long id, String email, long docid, String docname, String docspecialization, String status,
			Date date, String slot) {
		super();
		this.id = id;
		this.email = email;
		this.docid = docid;
		this.docname = docname;
		this.docspecialization = docspecialization;
		this.status = status;
		this.date = date;
		this.slot = slot;
	}

	public Appointment() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDocid() {
		return docid;
	}

	public void setDocid(long docid) {
		this.docid = docid;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDocspecialization() {
		return docspecialization;
	}

	public void setDocspecialization(String docspecialization) {
		this.docspecialization = docspecialization;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
	
}
